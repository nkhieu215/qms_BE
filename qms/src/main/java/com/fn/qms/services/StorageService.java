package com.fn.qms.services;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fn.handler.StorageException;
import com.fn.qms.config.StoreImageConfig;
import com.fn.qms.models.IqcLkdtRawData;
import com.fn.qms.repository.IqcLkdtRawDataRepository;
import com.fn.qms.utils.AppLog;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageService {
    @Autowired
    IqcLkdtRawDataRepository iqcLkdtRawDataRepository;
    private final Path rootLocation = Paths.get(StoreImageConfig.PATH);

    public List<String> store(MultipartFile[] files, String folder) {
        Path rootLocation = Paths.get(StoreImageConfig.PATH + "/" + folder);
        File dir = new File(StoreImageConfig.PATH + "/" + folder);
        if (!dir.exists()) dir.mkdirs();


        List<String> storedLocation = new ArrayList<>();
        for (MultipartFile file : files) {
            String extension = FilenameUtils.getExtension(file.getOriginalFilename());
            String filename = UUID.randomUUID().toString() +"." +extension;
            try {
                if (file.isEmpty()) {
                    throw new StorageException("Failed to store empty file " + filename);
                }
                if (filename.contains("..")) {
                    // This is a security check
                    throw new StorageException(
                            "Cannot store file with relative path outside current directory "
                                    + filename);
                }
                Files.copy(file.getInputStream(), rootLocation.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
                storedLocation.add("/" + folder + "/" + filename);
            } catch (IOException e) {
                throw new StorageException("Failed to store file " + filename, e);
            }
        }
        return storedLocation;
    }

    public Resource loadFile(String filename) {
        try {
            Path file = rootLocation.resolve(StoreImageConfig.PATH + filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("FAIL!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("FAIL!");
        }
    }

    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    public void init() {
        try {
            Files.createDirectory(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage!");
        }
    }
    public void downloadRawData(IqcLkdtRawData request){
        this.iqcLkdtRawDataRepository.save(request);
    }
}
