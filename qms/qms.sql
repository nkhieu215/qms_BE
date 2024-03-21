/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.5-10.4.17-MariaDB : Database - qms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`qms` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `qms`;

/*Table structure for table `iqc_audit_criteria_lkdt` */

DROP TABLE IF EXISTS `iqc_audit_criteria_lkdt`;

CREATE TABLE `iqc_audit_criteria_lkdt` (
  `audit_criteria_lkdt_id` int(11) NOT NULL,
  `audit_content` varchar(255) DEFAULT NULL COMMENT 'Chỉ tiêu đánh giá',
  `regulation_level` varchar(255) DEFAULT NULL COMMENT 'Mức quy định',
  `technical_requirement` varchar(255) DEFAULT NULL COMMENT 'Yêu cầu kĩ thuật',
  PRIMARY KEY (`audit_criteria_lkdt_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `iqc_audit_criteria_lkdt` */

/*Table structure for table `iqc_audit_criteria_nvl` */

DROP TABLE IF EXISTS `iqc_audit_criteria_nvl`;

CREATE TABLE `iqc_audit_criteria_nvl` (
  `audit_criteria_id` int(11) NOT NULL,
  `criteria_name` varchar(255) DEFAULT NULL COMMENT 'Tên tiêu chí',
  `regulation_level` varchar(255) DEFAULT NULL COMMENT 'MucQuyDinh',
  `Min` float(11,0) DEFAULT NULL COMMENT 'ThongSoMin',
  `Max` float(11,0) DEFAULT NULL COMMENT 'ThongSoMin',
  `unit` varchar(255) DEFAULT NULL COMMENT 'Đơn vị',
  `Note` varchar(255) DEFAULT NULL COMMENT 'NoiDungLuuY',
  `examination_type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`audit_criteria_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `iqc_audit_criteria_nvl` */

/*Table structure for table `iqc_audit_result_lkdt` */

DROP TABLE IF EXISTS `iqc_audit_result_lkdt`;

CREATE TABLE `iqc_audit_result_lkdt` (
  `audit_result_lkdt_id` int(11) NOT NULL,
  `quantity` int(11) DEFAULT NULL COMMENT 'So luong',
  `inaccuracy` varchar(255) DEFAULT NULL COMMENT 'Sai so thuc te',
  `check_result` varchar(255) DEFAULT NULL COMMENT 'Kết quả đánh giá',
  `check_content` varchar(255) DEFAULT NULL COMMENT 'Nội dung đánh giá',
  `elect_comp_id` int(11) DEFAULT NULL,
  `audit_critetia_lkdt_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`audit_result_lkdt_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `iqc_audit_result_lkdt` */

/*Table structure for table `iqc_audit_result_nvl` */

DROP TABLE IF EXISTS `iqc_audit_result_nvl`;

CREATE TABLE `iqc_audit_result_nvl` (
  `audit_result_nvl_id` int(11) NOT NULL,
  `elect_comp_id` int(11) DEFAULT NULL,
  `audit_criteria_id` int(11) DEFAULT NULL,
  `orther_requerement` varchar(255) DEFAULT NULL COMMENT 'Yêu cầu khác',
  `Quantity` varchar(255) DEFAULT NULL COMMENT 'Số lượng',
  `Min` float(11,0) DEFAULT NULL COMMENT 'Kết quả kiểm tra Min',
  `Max` float(11,0) DEFAULT NULL COMMENT 'Kết quả kiểm tra Max',
  `unit` varchar(255) DEFAULT NULL COMMENT 'Đơn vị',
  `check_result` varchar(255) DEFAULT NULL COMMENT 'Kết quả đánh giá',
  `Note` varchar(255) DEFAULT NULL COMMENT 'Noi dung ghi chu',
  `item_type` varchar(255) DEFAULT NULL COMMENT 'Loại hàng hoá: Hang Nhap / Hang Mau',
  `approve_status` varchar(255) DEFAULT NULL COMMENT 'Trang thai phe duyet bien ban. Sau khi luu thi lanh dao phe duyet',
  PRIMARY KEY (`audit_result_nvl_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `iqc_audit_result_nvl` */

/*Table structure for table `iqc_elect_comp_err` */

DROP TABLE IF EXISTS `iqc_elect_comp_err`;

CREATE TABLE `iqc_elect_comp_err` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `err_group` varchar(255) DEFAULT NULL COMMENT 'Nhóm lỗi',
  `err_name` varchar(255) DEFAULT NULL COMMENT 'Tên lỗi',
  `quantity` int(11) DEFAULT NULL COMMENT 'số lượng',
  `ratio` varchar(255) DEFAULT NULL COMMENT 'tỉ lệ',
  `elect_comp_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `fk_LoiLinhKien_iqc_electronic_component_1` (`elect_comp_id`),
  CONSTRAINT `fk_LoiLinhKien_iqc_electronic_component_1` FOREIGN KEY (`elect_comp_id`) REFERENCES `iqc_electronic_component` (`elect_comp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `iqc_elect_comp_err` */

/*Table structure for table `iqc_electronic_component` */

DROP TABLE IF EXISTS `iqc_electronic_component`;

CREATE TABLE `iqc_electronic_component` (
  `elect_comp_id` int(11) NOT NULL,
  `elec_comp_code` varchar(255) DEFAULT NULL COMMENT 'Mã linh kiện',
  `elect_comp_name` varchar(255) DEFAULT NULL COMMENT 'Tên linh kiện',
  `PO_quantity` varchar(255) DEFAULT NULL COMMENT 'Số lượng PO',
  `import_date` date DEFAULT NULL COMMENT 'Ngày nhập hàng',
  `Check_date` date DEFAULT NULL COMMENT 'Ngày kiểm tra',
  `batch_number` varchar(255) DEFAULT NULL COMMENT 'Số lô',
  `invoice_number` varchar(255) DEFAULT NULL COMMENT 'Số Hoá đơn',
  `origin` varchar(255) DEFAULT NULL COMMENT 'Xuất xử',
  `GRPOnumber` varchar(255) DEFAULT NULL COMMENT 'Số GRPO',
  `checking_quantity` int(11) DEFAULT NULL COMMENT 'Số lượng kiểm tra',
  `SPKPH_number` varchar(255) DEFAULT NULL COMMENT 'Lập phiếu SPKPH số',
  `conclusion` varchar(255) DEFAULT NULL COMMENT 'Kết luận đánh giá: Dat nhap kho/ khong dat tra ve/ Nhap kho nhan nhuong',
  `report_code` varchar(255) DEFAULT NULL COMMENT 'Mã biên bản số:hh:ss/DD/MM/YYYY/ BAN QLCL',
  PRIMARY KEY (`elect_comp_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='Bảng lưu thông tin kiểm tra linh kiện IQC';

/*Data for the table `iqc_electronic_component` */

/*Table structure for table `iqc_examination_type` */

DROP TABLE IF EXISTS `iqc_examination_type`;

CREATE TABLE `iqc_examination_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `type_examination_id` int(11) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT 'Trạng thái kích hoạt. 1 la kich hoat. 0 la khong kich hoat',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='Chia làm 2 phần : +) Biểu mẫu kiểm tra NVL /BTP/TP \n+) Biểu mẫu kiểm tra LKĐT, Thông số \n';

/*Data for the table `iqc_examination_type` */

/*Table structure for table `iqc_parameter` */

DROP TABLE IF EXISTS `iqc_parameter`;

CREATE TABLE `iqc_parameter` (
  `parameter_id` int(11) NOT NULL,
  `parameter_name` varchar(255) DEFAULT NULL COMMENT 'Thông số',
  `condition` varchar(255) DEFAULT NULL COMMENT 'Điều kiện',
  `Min` float(255,0) DEFAULT NULL,
  `Max` float(255,0) DEFAULT NULL,
  `Unit` varchar(255) DEFAULT NULL COMMENT 'Đơn vị',
  PRIMARY KEY (`parameter_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `iqc_parameter` */

/*Table structure for table `iqc_parameter_audit_result` */

DROP TABLE IF EXISTS `iqc_parameter_audit_result`;

CREATE TABLE `iqc_parameter_audit_result` (
  `parameter_audit_result_id` int(11) NOT NULL,
  `q_avg` varchar(255) DEFAULT NULL COMMENT 'Q trung bình',
  `quantity` int(11) DEFAULT NULL,
  `Min` float(255,0) DEFAULT NULL,
  `Max` float(255,0) DEFAULT NULL,
  `avg` float(255,0) DEFAULT NULL,
  `S` varchar(255) DEFAULT NULL,
  `KU` varchar(255) DEFAULT NULL,
  `KL` varchar(255) DEFAULT NULL,
  `check_result` varchar(255) DEFAULT NULL COMMENT 'Đánh giá',
  `content` varchar(255) DEFAULT NULL COMMENT 'Nôi dung',
  `parameter_id` int(11) DEFAULT NULL,
  `elect_comp_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`parameter_audit_result_id`) USING BTREE,
  KEY `fk_iqc_parameter_audit_result_iqc_parameter_1` (`parameter_id`),
  KEY `fk_iqc_parameter_audit_result_iqc_electronic_component_1` (`elect_comp_id`),
  CONSTRAINT `fk_iqc_parameter_audit_result_iqc_electronic_component_1` FOREIGN KEY (`elect_comp_id`) REFERENCES `iqc_electronic_component` (`elect_comp_id`),
  CONSTRAINT `fk_iqc_parameter_audit_result_iqc_parameter_1` FOREIGN KEY (`parameter_id`) REFERENCES `iqc_parameter` (`parameter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `iqc_parameter_audit_result` */

/*Table structure for table `menu` */

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `path` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `class` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `permission` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `menu` */

/*Table structure for table `pqc_bom_workorder` */

DROP TABLE IF EXISTS `pqc_bom_workorder`;

CREATE TABLE `pqc_bom_workorder` (
  `id` int(11) NOT NULL,
  `work_order_id` int(11) DEFAULT NULL,
  `item_name` varchar(255) DEFAULT NULL COMMENT 'Tên vật tư',
  `item_code` varchar(255) DEFAULT NULL COMMENT 'Mã vật tư',
  `quantity` int(11) DEFAULT NULL COMMENT 'Bang so luong sx * so luong bom',
  `part_number` varchar(255) DEFAULT NULL,
  `vendor` varchar(255) DEFAULT NULL,
  `version` varchar(255) DEFAULT NULL,
  `bom_quantity` varchar(255) DEFAULT NULL COMMENT 'So luong trong bom',
  `work_order_quantity` varchar(255) DEFAULT NULL COMMENT 'So luong sx',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `pqc_bom_workorder` */

/*Table structure for table `pqc_draw_test_nvl` */

DROP TABLE IF EXISTS `pqc_draw_test_nvl`;

CREATE TABLE `pqc_draw_test_nvl` (
  `draw_test_nvl_id` int(11) NOT NULL,
  `item_code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `item_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `technical_para` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `part_number` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `rank_ap` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `rank_quang` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `rank_mau` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lot` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `po_code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `manufacture_date` datetime DEFAULT NULL COMMENT 'Ngày sản xuất',
  `qty` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `vendor` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sample_quantity` int(11) DEFAULT NULL COMMENT 'Số mẫu thử',
  `check_date` datetime DEFAULT NULL COMMENT 'Ngày kiểm tra',
  `regulation_check` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Quy định kiểm tra',
  `allow_result` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Kết quả cho phép',
  `real_result` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Kết quả thực tế',
  `min_power` int(11) DEFAULT NULL COMMENT 'Công suất min',
  `max_power` int(11) DEFAULT NULL COMMENT 'cong suất max',
  `min_cosfi` int(11) DEFAULT NULL,
  `max_cosfi` int(11) DEFAULT NULL,
  `min_electric` int(11) DEFAULT NULL COMMENT 'dòng điện min',
  `max_electric` int(11) DEFAULT NULL COMMENT 'dòng điện max',
  `note` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'GHi chú',
  `external_inspection` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'ngoại quan',
  `profile_id` int(11) DEFAULT NULL,
  `work_order_id` int(11) DEFAULT NULL COMMENT 'Id lệnh sản xuất',
  PRIMARY KEY (`draw_test_nvl_id`),
  KEY `fk_pqc_draw_test_nvl_profile_1` (`profile_id`),
  CONSTRAINT `fk_pqc_draw_test_nvl_profile_1` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`profile_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `pqc_draw_test_nvl` */

/*Table structure for table `pqc_dttd_mount_comp_check` */

DROP TABLE IF EXISTS `pqc_dttd_mount_comp_check`;

CREATE TABLE `pqc_dttd_mount_comp_check` (
  `dttd_mount_comp_id` int(11) NOT NULL,
  `batch_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'lo san xuat',
  `line` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'day chuyên sản xuất',
  `check_person` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Nguòi kiem tra',
  `check_time` datetime DEFAULT NULL COMMENT 'Thời gian',
  `expiry_date` datetime DEFAULT NULL COMMENT 'hạn sử dụng',
  `quatity` int(11) DEFAULT NULL COMMENT 'so luong kiem tra',
  `err_total` int(11) DEFAULT NULL COMMENT 'tổng lỗi',
  `conclude` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Kết luận',
  `Note` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Ghi chú',
  `work_order_id` int(11) DEFAULT NULL,
  `machine_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'tên máy',
  PRIMARY KEY (`dttd_mount_comp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Kiểm tra gắn linh kiện điện tử\n';

/*Data for the table `pqc_dttd_mount_comp_check` */

/*Table structure for table `pqc_dttd_solder_check` */

DROP TABLE IF EXISTS `pqc_dttd_solder_check`;

CREATE TABLE `pqc_dttd_solder_check` (
  `dttd_solder_check_id` int(11) NOT NULL,
  `batch_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'lo san xuat',
  `line` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'day chuyên sản xuất',
  `check_person` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Nguòi kiem tra',
  `check_time` datetime DEFAULT NULL COMMENT 'Thời gian',
  `quatity` int(11) DEFAULT NULL COMMENT 'so luong kiem tra',
  `err_total` int(11) DEFAULT NULL COMMENT 'tổng lỗi',
  `conclude` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Kết luận',
  `Note` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Ghi chú',
  `work_order_id` int(11) DEFAULT NULL,
  `machine_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'ten may',
  PRIMARY KEY (`dttd_solder_check_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Kiểm tra công đoạn in kem thiếc \n';

/*Data for the table `pqc_dttd_solder_check` */

/*Table structure for table `pqc_dttd_tin_check` */

DROP TABLE IF EXISTS `pqc_dttd_tin_check`;

CREATE TABLE `pqc_dttd_tin_check` (
  `dttd_check_id` int(11) NOT NULL,
  `batch_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'lo san xuat',
  `line` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'day chuyên sản xuất',
  `check_person` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Nguòi kiem tra',
  `check_time` datetime DEFAULT NULL COMMENT 'Thời gian',
  `expiry_date` datetime DEFAULT NULL COMMENT 'hạn sử dụng',
  `quatity` int(11) DEFAULT NULL COMMENT 'so luong kiem tra',
  `err_total` int(11) DEFAULT NULL COMMENT 'tổng lỗi',
  `conclude` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Kết luận',
  `Note` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Ghi chú',
  `work_order_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`dttd_check_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Kiểm tra công đoạn in kem thiếc \n';

/*Data for the table `pqc_dttd_tin_check` */

/*Table structure for table `pqc_error_list` */

DROP TABLE IF EXISTS `pqc_error_list`;

CREATE TABLE `pqc_error_list` (
  `id` int(11) NOT NULL,
  `err_group` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Nhóm lỗi',
  `err_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'tên lỗi',
  `quantity` int(11) DEFAULT NULL COMMENT 'so luong',
  `ratio` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'tỉ lệ',
  `dttd_check_id` int(11) DEFAULT NULL,
  `dttd_type` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '5: in thiec; 6: gan linh kien; 7: lo han',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Kiểm tra công đoạn in kem thiếc \n';

/*Data for the table `pqc_error_list` */

/*Table structure for table `pqc_test_nvl_all` */

DROP TABLE IF EXISTS `pqc_test_nvl_all`;

CREATE TABLE `pqc_test_nvl_all` (
  `test_nvl_id` int(11) NOT NULL,
  `item_code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `item_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `technical_para` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `part_number` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `rank_ap` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `rank_quang` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `rank_mau` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lot` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `po_code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `manufacture_date` datetime DEFAULT NULL COMMENT 'Ngày sản xuất',
  `qty` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `vendor` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `chain_code_detail` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Chi tiết chuỗi mã quet QR lan 1',
  `status` binary(255) DEFAULT NULL COMMENT 'True/false',
  `feeder_code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Mã feeder',
  `scan_time` datetime DEFAULT NULL COMMENT 'Thời gian scan',
  `profile_id` int(11) DEFAULT NULL,
  `work_order_id` int(11) DEFAULT NULL COMMENT 'Id lệnh sản xuất',
  `chain_code_detal_qr_scan2` int(11) DEFAULT NULL COMMENT 'Chi tiết chuối mã quét lần 2',
  PRIMARY KEY (`test_nvl_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `pqc_test_nvl_all` */

/*Table structure for table `pqc_work_order` */

DROP TABLE IF EXISTS `pqc_work_order`;

CREATE TABLE `pqc_work_order` (
  `work_order_id` int(11) NOT NULL COMMENT 'id lenh san xuat',
  `production_code` varchar(255) DEFAULT NULL COMMENT 'Ma san pham',
  `planing_work_order_code` varchar(255) DEFAULT NULL COMMENT 'Ma lenh san xuat',
  `purchase_order_code` varchar(255) DEFAULT NULL COMMENT 'Ma don hang',
  `bom_version` varchar(255) DEFAULT NULL,
  `RutNghiem` varchar(255) DEFAULT NULL COMMENT 'Nhan vien thuc hien rut nghiem  vat tu',
  `rutnghiem_nvl_result` varchar(255) DEFAULT NULL COMMENT 'Kết quả rút nghiệm nvl',
  `KiemTraNVL` varchar(255) DEFAULT NULL COMMENT 'Nhan vien',
  `kiemtra_nvl_result` varchar(255) DEFAULT NULL COMMENT 'Kết quả kiểm tra nvl 100%',
  `InKem` varchar(255) DEFAULT NULL COMMENT 'Nhan vien',
  `GanLK` varchar(255) DEFAULT NULL COMMENT 'Nhan vien',
  `LoHan` varchar(255) DEFAULT NULL COMMENT 'Nhan vien',
  `KimLoai` varchar(255) DEFAULT NULL COMMENT 'Nhan vien',
  `Nhua` varchar(255) DEFAULT NULL COMMENT 'Nhan vien',
  `Son` varchar(255) DEFAULT NULL COMMENT 'Nhan vien',
  `KiemTraLapLan` varchar(255) DEFAULT NULL COMMENT 'Nhan vien',
  `KTQuaTrinhSX` varchar(255) DEFAULT NULL COMMENT 'Nhan vien',
  `KTQuangDien` varchar(255) DEFAULT NULL COMMENT 'Nhan vien',
  `KTQuangDienBTP` varchar(255) DEFAULT NULL COMMENT 'Nhan vien',
  `KTLoiSuaLai` varchar(255) DEFAULT NULL COMMENT 'Nhan vien',
  `KTChiTietNhapKho` varchar(255) DEFAULT NULL COMMENT 'Nhan vien',
  `MauDanhGiaCLSP` varchar(255) DEFAULT NULL COMMENT 'Nhan vien',
  `DuyetNhapKho` varchar(255) DEFAULT NULL COMMENT 'Nhan vien duyet nhap kho',
  `profile_id` int(11) DEFAULT NULL,
  `planing_work_order_id` int(11) DEFAULT NULL COMMENT 'id lệnh sản xuất'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='PQC \nTạo lệnh sản xuất';

/*Data for the table `pqc_work_order` */

/*Table structure for table `profile` */

DROP TABLE IF EXISTS `profile`;

CREATE TABLE `profile` (
  `profile_name` varchar(255) DEFAULT NULL,
  `partnumber` int(11) DEFAULT NULL,
  `sub_partnumber` int(11) DEFAULT NULL,
  `profile_id` int(11) NOT NULL,
  `MaThietBi` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`profile_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `profile` */

/*Table structure for table `roles` */

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `roles` */

insert  into `roles`(`id`,`name`) values (1,'ROLE_USER'),(2,'ROLE_MODERATOR'),(3,'ROLE_ADMIN');

/*Table structure for table `user_roles` */

DROP TABLE IF EXISTS `user_roles`;

CREATE TABLE `user_roles` (
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user_roles` */

insert  into `user_roles`(`user_id`,`role_id`) values (1,3),(1,2),(1,1);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `users` */

insert  into `users`(`id`,`username`,`email`,`password`) values (1,'dongvt','dongvt221990@gmail.com','$2a$10$VmPq9X4stTzeO3LKCIrDfuXjRudEQFDkUcJ1rfICOCbTGiK9dJNie');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
