package com.fn.qms.repository.DAO;

import java.util.ArrayList;
import java.util.List;

import com.fn.qms.security.services.UserDetailsImpl;
import com.fn.qms.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fn.qms.models.Menu;
import com.fn.qms.repository.MenuRepository;
import com.fn.qms.rest.bean.MenuRes;

@Service
public class UserService {

    @Autowired
    MenuRepository menuRepository;

    public List<String> lstPermission() {
        List<String> lst = new ArrayList<String>();

        List<Menu> lstmenu = menuRepository.getMenuParent();

        return lst;
    }

    public List<MenuRes> getAllMenu(UserDetailsImpl user) {
        List<MenuRes> arrMenu = new ArrayList<MenuRes>();
        List<Menu> menulst = menuRepository.getMenuParent();


        MenuRes menuRes;
        if (menulst != null) {
            for (Menu menu : menulst) {
                menuRes = new MenuRes();
                menuRes.setName(menu.getName());
                menuRes.setClassIcon(menu.getClass_());
                menuRes.setUrl(menu.getPath());

                boolean checkRole = true;
                if (!Utils.isNull(menu.getPermission())) {
                    String[] roles = menu.getPermission().split(",");
                    for (String role : roles) {
                        if (user.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals(role))) {
                            checkRole = false;
                        }
                    }
                }

                if (checkRole && menu.getMenus() != null && !menu.getMenus().isEmpty()) {
                    List<MenuRes> arrMenuChild = new ArrayList<MenuRes>();
                    MenuRes menuResChild;
                    for (Menu menuChild : menu.getMenus()) {
                        menuResChild = new MenuRes();
                        menuResChild.setName(menuChild.getName());
                        menuResChild.setClassIcon(menuChild.getClass_());
                        menuResChild.setUrl(menuChild.getPath());
                        menuResChild.setPermission(menuChild.getPermission());

                        if (!Utils.isNull(menuChild.getPermission())) {
                            String[] roles = menuChild.getPermission().split(",");
                            for (String role : roles) {
                                if (user.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals(role))) {
                                    arrMenuChild.add(menuResChild);
                                    break;
                                }
                            }
                        } else {
                            arrMenuChild.add(menuResChild);
                        }
                    }
                    menuRes.setLstChild(arrMenuChild);
                }

                if (checkRole)
                    arrMenu.add(menuRes);
            }
        }
        return arrMenu;
    }
}
