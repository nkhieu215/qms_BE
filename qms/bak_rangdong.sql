/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.5-10.4.17-MariaDB : Database - rangdong
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`rangdong` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `rangdong`;

/*Table structure for table `action_log` */

DROP TABLE IF EXISTS `action_log`;

CREATE TABLE `action_log` (
  `action_log_id` int(11) NOT NULL,
  `start_time` date DEFAULT NULL,
  `end_time` date DEFAULT NULL,
  `process_name` varchar(45) DEFAULT NULL,
  `module_code` varchar(45) DEFAULT NULL,
  `request_content` varchar(45) DEFAULT NULL,
  `response_content` varchar(45) DEFAULT NULL,
  `error_code` varchar(45) DEFAULT NULL,
  `error_description` varchar(255) DEFAULT NULL,
  `user_name` varchar(45) DEFAULT NULL,
  `request_ip_address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`action_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `action_log` */

/*Table structure for table `catalog_stage_mapping` */

DROP TABLE IF EXISTS `catalog_stage_mapping`;

CREATE TABLE `catalog_stage_mapping` (
  `id` int(11) NOT NULL,
  `product_catalog_code` varchar(45) DEFAULT NULL,
  `product_stage_code` varchar(45) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `stage_error_mapping_id` int(11) NOT NULL,
  `stage_code_stage_code` varchar(45) NOT NULL,
  `product_catalog_product_catalog_code` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `catalog_stage_mapping` */

/*Table structure for table `cmc_oitm` */

DROP TABLE IF EXISTS `cmc_oitm`;

CREATE TABLE `cmc_oitm` (
  `Itemcode` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `ItemName` varchar(250) CHARACTER SET utf8 DEFAULT NULL,
  `U_IGroup` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `U_RDCode` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `U_ProductBranch` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `Quantity` float DEFAULT NULL,
  `PlannedQty` float DEFAULT NULL,
  `RjctQty` float DEFAULT NULL,
  `Warehouse` varchar(100) DEFAULT NULL,
  `BaseEntry` bigint(20) DEFAULT NULL,
  `BaseLine` bigint(20) DEFAULT NULL,
  `BaseType` bigint(20) DEFAULT NULL,
  `DocStatus` varchar(20) DEFAULT NULL,
  `Usersign` varchar(100) DEFAULT NULL,
  `Usersign2` varchar(100) DEFAULT NULL,
  `Createdate` date DEFAULT NULL,
  `Createtime` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `cmc_oitm` */

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `employee_id` int(11) NOT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `employee_code` varchar(45) DEFAULT NULL,
  `user_name` varchar(45) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Nhân viên';

/*Data for the table `employee` */

/*Table structure for table `error_list` */

DROP TABLE IF EXISTS `error_list`;

CREATE TABLE `error_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `type` int(11) DEFAULT NULL COMMENT 'loai loi',
  `description` varchar(200) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `error_code` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

/*Data for the table `error_list` */

insert  into `error_list`(`id`,`name`,`parent_id`,`created_at`,`updated_at`,`type`,`description`,`error_code`) values (1,'LED',NULL,'2021-11-07 03:08:31','2021-11-07 03:08:31',NULL,'là lỗi','ML1'),(2,'Nứt vỡ led',1,'2021-11-07 09:25:57','2021-11-07 09:25:57',NULL,'Lỗi biên bản NVL','LED2'),(3,'Chết led',1,'2021-11-07 09:31:28','2021-11-07 09:31:28',NULL,'mo tả','LED3'),(4,'Mối hàn LED',1,'2021-11-07 09:31:28','2021-11-07 09:31:28',NULL,NULL,'LED4'),(5,'Led sáng mờ',1,'2021-11-07 09:31:28','2021-11-07 09:31:28',NULL,NULL,'LED5');

/*Table structure for table `error_type` */

DROP TABLE IF EXISTS `error_type`;

CREATE TABLE `error_type` (
  `error_type_id` int(11) NOT NULL,
  `error_type_code` varchar(45) NOT NULL,
  `error_type_name` varchar(45) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `error_error_id` int(11) NOT NULL,
  PRIMARY KEY (`error_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `error_type` */

/*Table structure for table `line` */

DROP TABLE IF EXISTS `line`;

CREATE TABLE `line` (
  `line_id` int(11) NOT NULL,
  `line_name` varchar(255) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `work_center_id` int(11) DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  `input_quantity` int(11) DEFAULT NULL COMMENT 'sản lượng đầu vào',
  `performance` varchar(45) DEFAULT NULL COMMENT 'năng suất bình quân',
  `error_ratio` float DEFAULT NULL COMMENT 'tỷ lệ lỗi',
  `line_machine_monitor_line_machine_monitor_id` int(11) NOT NULL,
  PRIMARY KEY (`line_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Dây chuyền';

/*Data for the table `line` */

/*Table structure for table `line_machine_monitor` */

DROP TABLE IF EXISTS `line_machine_monitor`;

CREATE TABLE `line_machine_monitor` (
  `line_machine_monitor_id` int(11) NOT NULL,
  `line_id` int(11) DEFAULT NULL,
  `machine_id` int(11) DEFAULT NULL,
  `planning_work_order_detail_id` int(11) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL COMMENT 'đang chạy hay dừng',
  `input_quantity` int(11) DEFAULT NULL,
  `output_quantity` int(11) DEFAULT NULL COMMENT 'số lượng hiện tại',
  `running_time` bigint(20) DEFAULT NULL,
  `sap_work_order_id` varchar(45) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `stop_time` datetime DEFAULT NULL,
  `error_quantity` int(11) DEFAULT NULL COMMENT 'số lỗi',
  PRIMARY KEY (`line_machine_monitor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `line_machine_monitor` */

/*Table structure for table `machine` */

DROP TABLE IF EXISTS `machine`;

CREATE TABLE `machine` (
  `machine_id` int(11) NOT NULL,
  `machine_name` varchar(45) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `work_center_id` int(11) DEFAULT NULL,
  `line_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`machine_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Máy	';

/*Data for the table `machine` */

/*Table structure for table `order_item` */

DROP TABLE IF EXISTS `order_item`;

CREATE TABLE `order_item` (
  `order_item_id` varchar(45) NOT NULL,
  `product_code` int(11) NOT NULL,
  `product_name` varchar(45) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `unit_name` varchar(45) DEFAULT NULL COMMENT 'đơn vi tính',
  PRIMARY KEY (`order_item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `order_item` */

/*Table structure for table `planning_production_order` */

DROP TABLE IF EXISTS `planning_production_order`;

CREATE TABLE `planning_production_order` (
  `PO_ID` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `order_item` varchar(45) NOT NULL,
  `order_date` date DEFAULT NULL,
  `expected_complete_date` date DEFAULT NULL,
  `complete_date` date DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `priority` varchar(45) DEFAULT NULL,
  `requested_start_date` date DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `bom_version` varchar(45) DEFAULT '(có ở đây hay chưa hay chọn lúc tạo KBSX)',
  `created_date` date DEFAULT NULL,
  `last_modified_date` date DEFAULT NULL,
  `order_item_product_code` int(11) NOT NULL,
  PRIMARY KEY (`PO_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `planning_production_order` */

/*Table structure for table `planning_work_order` */

DROP TABLE IF EXISTS `planning_work_order`;

CREATE TABLE `planning_work_order` (
  `planning_work_order_id` int(11) NOT NULL,
  `sap_WO_ID` varchar(45) DEFAULT NULL,
  `LINE_ID` int(11) DEFAULT NULL,
  `START_TIME` date DEFAULT NULL,
  `END_TIME` date DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `PRODUCT_ORDER_ID` int(11) DEFAULT NULL,
  `PRODUCT_ID` int(11) DEFAULT NULL,
  `QUANTITY_PLAN` int(11) DEFAULT NULL,
  `bom_version` varchar(45) DEFAULT NULL,
  `branch_code` varchar(45) DEFAULT NULL COMMENT 'Ngành',
  `group_code` varchar(45) DEFAULT NULL COMMENT 'tổ',
  `group_name` varchar(45) DEFAULT NULL,
  `sap_cmc_oitm_Itemcode` varchar(100) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`planning_work_order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `planning_work_order` */

/*Table structure for table `planning_work_order_assignment` */

DROP TABLE IF EXISTS `planning_work_order_assignment`;

CREATE TABLE `planning_work_order_assignment` (
  `PLANNING_DETAIL_ID` int(11) NOT NULL,
  `START_TIME` date DEFAULT NULL,
  `END_TIME` date DEFAULT NULL,
  `EXPTECTED` int(11) DEFAULT NULL,
  `ACTUAL` int(11) DEFAULT NULL,
  `STATUS` int(11) DEFAULT NULL,
  `STATE` varchar(45) DEFAULT NULL,
  `PLANNING` int(11) DEFAULT NULL,
  `LINE_ID` int(11) DEFAULT NULL,
  `MACHINE_ID` int(11) DEFAULT NULL,
  `WORK_CENTER_ID` int(11) DEFAULT NULL,
  `QA_EMPLOYEE` varchar(45) DEFAULT NULL,
  `bom_version` varchar(45) DEFAULT NULL,
  `batch_id` varchar(45) DEFAULT NULL,
  `perform_employee` varchar(45) DEFAULT NULL,
  `sap_work_order` varchar(45) DEFAULT NULL,
  `machine_machine_id` int(11) NOT NULL,
  `line_line_id` int(11) NOT NULL,
  `employee_employee_id` int(11) NOT NULL,
  `sap_owor_DocEntry` int(11) NOT NULL,
  `sap_branch_group_Code` int(11) NOT NULL,
  `planning_work_order_planning_work_order_id` int(11) NOT NULL,
  `sap_batch_Code` varchar(50) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`PLANNING_DETAIL_ID`,`machine_machine_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `planning_work_order_assignment` */

/*Table structure for table `product_catalog` */

DROP TABLE IF EXISTS `product_catalog`;

CREATE TABLE `product_catalog` (
  `product_catalog_code` varchar(45) NOT NULL,
  `product_catalog_name` varchar(45) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`product_catalog_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `product_catalog` */

/*Table structure for table `sap_batch` */

DROP TABLE IF EXISTS `sap_batch`;

CREATE TABLE `sap_batch` (
  `Code` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT 'Mã lô',
  `Name` varchar(100) CHARACTER SET utf8 NOT NULL COMMENT 'Tên lô ',
  `U_Production` int(11) DEFAULT NULL COMMENT '(SỐ lệnh sản xuất) Lấy theo mục DocNum trên bảng lệnh sản xuất',
  `U_DChuyen` varchar(250) CHARACTER SET utf8 DEFAULT NULL,
  `U_Date` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`Code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Quản lý mã lệnh sản xuất có những lô sản xuất nào';

/*Data for the table `sap_batch` */

/*Table structure for table `sap_bom_version` */

DROP TABLE IF EXISTS `sap_bom_version`;

CREATE TABLE `sap_bom_version` (
  `U_ProNo` varchar(100) NOT NULL,
  `U_Proname` varchar(45) DEFAULT NULL,
  `ProducitonNo` varchar(45) DEFAULT NULL COMMENT '(mã sản phẩm, BTP)',
  `ProductName` varchar(45) DEFAULT NULL COMMENT 'tên thể hiện của sản phẩm hoặc BTP',
  `Warehouse` varchar(45) DEFAULT NULL COMMENT 'Mã kho nhập kho sản xuất của TP/BTP)',
  `Versions` varchar(45) DEFAULT NULL COMMENT 'Version BOM của TP/BTP)',
  `Speciality` varchar(45) DEFAULT NULL COMMENT '(ĐIểm đặc biệt với BOM)',
  `Remark` varchar(45) DEFAULT NULL COMMENT 'Lưu ý của BOM )',
  `StartDate` date DEFAULT NULL COMMENT 'ngày bắt đầu)',
  `DueDate` date DEFAULT NULL COMMENT '(Ngày dự kiến hoàn thành)',
  `Active` int(11) DEFAULT NULL COMMENT 'Trạng thái của BOM Version với Sản phẩm, BTP  Active – YES or No',
  `U_DocURL` varchar(45) DEFAULT NULL COMMENT 'link đến tài liệu BOM version',
  `id` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `sap_bom_version` */

/*Table structure for table `sap_branch_group` */

DROP TABLE IF EXISTS `sap_branch_group`;

CREATE TABLE `sap_branch_group` (
  `danh sách tổ,ngành` varchar(45) DEFAULT NULL,
  `Code` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Mã tự sinh trong bảng để quản lý ',
  `Name` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT 'Trường tên mô tả cho mục 2',
  `U_BranchCode` varchar(10) CHARACTER SET utf8 DEFAULT NULL COMMENT 'Mã ngành',
  `U_BranchName` varchar(254) CHARACTER SET utf8 DEFAULT NULL COMMENT 'Mô tả tên ngành',
  `U_GroupCode` varchar(10) CHARACTER SET utf8 DEFAULT NULL COMMENT 'Mã Tổ',
  `U_GroupName` varchar(254) CHARACTER SET utf8 DEFAULT NULL COMMENT 'Tên Tổ',
  `U_FactoryCode` varchar(10) CHARACTER SET utf8 DEFAULT NULL COMMENT 'Mã Xưởng',
  `U_FactoryName` varchar(254) CHARACTER SET utf8 DEFAULT NULL COMMENT 'Tên Xưởng',
  PRIMARY KEY (`Code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `sap_branch_group` */

/*Table structure for table `sap_item` */

DROP TABLE IF EXISTS `sap_item`;

CREATE TABLE `sap_item` (
  `Itemcode` varchar(100) CHARACTER SET utf8 NOT NULL,
  `ItemName` varchar(250) CHARACTER SET utf8 DEFAULT NULL,
  `U_IGroup` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `U_RDCode` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `U_ProductBranch` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `U_ProductGroup` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `U_IGroupName` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `U_SubGRName` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `Usersign2` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `Createdate` datetime(3) DEFAULT NULL,
  `Createhourse` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `Status` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `Doctype` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`Itemcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `sap_item` */

/*Table structure for table `sap_list_bom` */

DROP TABLE IF EXISTS `sap_list_bom`;

CREATE TABLE `sap_list_bom` (
  `ItemCode` varchar(45) NOT NULL,
  `ItemName` varchar(45) DEFAULT NULL,
  `OtherItemName` varchar(45) DEFAULT NULL,
  `TechnicalName` varchar(45) DEFAULT NULL,
  `AlterItem` varchar(45) DEFAULT NULL,
  `ControlLevel` varchar(45) DEFAULT NULL,
  `PartNumber` varchar(45) DEFAULT NULL,
  `Location` varchar(45) DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL COMMENT '(Số lượng cơ bản cho 1 BTP hoặc SP)',
  `Vendor` varchar(45) DEFAULT NULL,
  `IssueMenthod` varchar(45) DEFAULT NULL,
  `sap_list_bomcol` varchar(45) DEFAULT NULL,
  `id` varchar(45) NOT NULL,
  `SAP_BOM_VERSION_id` varchar(45) NOT NULL,
  `SAP_OITM_ItemCode` varchar(50) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='BOM Version';

/*Data for the table `sap_list_bom` */

/*Table structure for table `sap_oitm` */

DROP TABLE IF EXISTS `sap_oitm`;

CREATE TABLE `sap_oitm` (
  `ItemName` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT 'Tên hàng hóa)',
  `ItemCode` varchar(50) CHARACTER SET utf8 NOT NULL,
  `FrgnName` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT 'Tên khác) lấy vào Version BOM',
  `ItmsGrpCod` smallint(6) DEFAULT 100 COMMENT 'Nhóm hàng hóa',
  `U_IGroup` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT 'mã chủngloại)',
  `U_SUBGR` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '(Mã nhóm)',
  `U_RDCODE` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT 'Mã Rạng ĐÔng dựa trên kết nối của  mục U_Igroup,U_SUBGR ,ItmsGrpcod , và chuỗi mã 4 ký tự cuối tự sinh',
  `U_IGroupName` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `U_SUBGRName` varchar(250) CHARACTER SET utf8 DEFAULT NULL,
  `U_ProductBranch` varchar(10) CHARACTER SET utf8 DEFAULT NULL COMMENT 'Ngành',
  `U_ProductGroup` varchar(10) CHARACTER SET utf8 DEFAULT NULL COMMENT 'Tổ',
  `U_Forcast` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT 'Hỗ trợ cho chạy kế hoạch MRP )',
  `U_ShortName` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT 'Tên ngắn)',
  `U_TechName` longtext DEFAULT NULL COMMENT '(tên Kỹ thuật) 	Dùng cho Bom version và hệ thống QMS',
  `U_DGroup` varchar(10) CHARACTER SET utf8 DEFAULT NULL COMMENT '(Phân nhóm sản phẩm)',
  `U_DGroupName` varchar(250) CHARACTER SET utf8 DEFAULT NULL,
  `U_Package` decimal(19,6) DEFAULT NULL COMMENT '(Số lượng/Thùng) Dùng cho thành phẩm và BTP',
  `U_MSL` longtext DEFAULT NULL COMMENT 'Mức độ bảo quản) Dùng cho quản lý Item',
  `U_PartNumber` varchar(254) CHARACTER SET utf8 DEFAULT NULL COMMENT 'PartNumber (Danh mục nhà cung cấp có thể cung cấp mặt hàng này) DÙng cho BOM version và QMS',
  PRIMARY KEY (`ItemCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `sap_oitm` */

/*Table structure for table `sap_workorder` */

DROP TABLE IF EXISTS `sap_workorder`;

CREATE TABLE `sap_workorder` (
  `bảng lệnh sản xuất` varchar(45) DEFAULT NULL,
  `DocEntry` int(11) NOT NULL,
  `DocNum` int(11) NOT NULL COMMENT 'Số lệnh sx (số tự tăng)',
  `ItemCode` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT 'Hiển thị Map từ mục 3 với bảng OITM để hiển thị tên chi tiết',
  `Status` char(1) DEFAULT 'P' COMMENT 'Trạng thái của lệnh sản xuất',
  `Type` char(1) DEFAULT 'S' COMMENT 'lệnh sản xuất',
  `PlannedQty` decimal(19,6) DEFAULT NULL COMMENT 'Số lượng kế hoạch',
  `PostDate` datetime(3) DEFAULT NULL COMMENT 'Ngày tạo số lệnh (phát sinh theo date khi Create lệnh sx)',
  `DueDate` datetime(3) DEFAULT NULL COMMENT 'Ngày dự kiến hoàn thành',
  `OriginNum` int(11) DEFAULT NULL COMMENT 'Mã đơn hàng bán',
  `OriginType` char(1) DEFAULT 'M' COMMENT 'Nguồn gốc sản xuất',
  `UserSign` smallint(6) DEFAULT NULL COMMENT 'Tên nhân viên tạo lệnh sản xuất',
  `CardCode` varchar(15) CHARACTER SET utf8 DEFAULT NULL COMMENT 'Mã khách hàng đặt hàng',
  `Warehouse` varchar(8) CHARACTER SET utf8 DEFAULT NULL COMMENT 'Mã kho nhập sản xuất',
  `Uom` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT 'Đơn vị tính',
  `CreateDate` datetime(3) DEFAULT NULL,
  `UpdateDate` datetime(3) DEFAULT NULL,
  `Project` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT 'Mã dự án',
  `SupplCode` varchar(254) CHARACTER SET utf8 DEFAULT NULL,
  `UomEntry` int(11) DEFAULT 0,
  `StartDate` datetime(3) DEFAULT NULL COMMENT 'Ngày bắt đầu',
  `U_RDCODE` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT 'Mã Rạng Đông của mã sản phẩm BTP đưa vào sx theo lệnh',
  `U_ProductCode` varchar(10) CHARACTER SET utf8 NOT NULL COMMENT 'mã lệnh sản xuất của Rạng Đông  (có thể bị thay đổi nên ko phải trường thông tin là duy nhất)',
  `U_Version` varchar(25) CHARACTER SET utf8 DEFAULT NULL COMMENT 'Phiên bản Version của BOM',
  `U_Spec` varchar(254) CHARACTER SET utf8 DEFAULT NULL COMMENT 'Đặc tính lưu ý của BOM',
  PRIMARY KEY (`DocEntry`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `sap_workorder` */

/*Table structure for table `stage_code` */

DROP TABLE IF EXISTS `stage_code`;

CREATE TABLE `stage_code` (
  `stage_code` varchar(45) NOT NULL COMMENT 'mã công đoạn',
  `stage_name` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`stage_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `stage_code` */

/*Table structure for table `stage_error_mapping` */

DROP TABLE IF EXISTS `stage_error_mapping`;

CREATE TABLE `stage_error_mapping` (
  `id` int(11) NOT NULL,
  `product_stage_code` varchar(45) DEFAULT NULL,
  `error_code` varchar(45) NOT NULL,
  `status` int(11) NOT NULL,
  `error_list_error_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `stage_error_mapping` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
