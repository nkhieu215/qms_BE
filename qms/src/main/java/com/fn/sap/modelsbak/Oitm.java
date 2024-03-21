/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fn.sap.modelsbak;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dong
 */
@Entity
@Table(name = "oitm")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oitm.findAll", query = "SELECT o FROM Oitm o"),
    @NamedQuery(name = "Oitm.findByItemCode", query = "SELECT o FROM Oitm o WHERE o.itemCode = :itemCode"),
    @NamedQuery(name = "Oitm.findByItemName", query = "SELECT o FROM Oitm o WHERE o.itemName = :itemName"),
    @NamedQuery(name = "Oitm.findByFrgnName", query = "SELECT o FROM Oitm o WHERE o.frgnName = :frgnName"),
    @NamedQuery(name = "Oitm.findByItmsGrpCod", query = "SELECT o FROM Oitm o WHERE o.itmsGrpCod = :itmsGrpCod"),
    @NamedQuery(name = "Oitm.findByCstGrpCode", query = "SELECT o FROM Oitm o WHERE o.cstGrpCode = :cstGrpCode"),
    @NamedQuery(name = "Oitm.findByVatGourpSa", query = "SELECT o FROM Oitm o WHERE o.vatGourpSa = :vatGourpSa"),
    @NamedQuery(name = "Oitm.findByCodeBars", query = "SELECT o FROM Oitm o WHERE o.codeBars = :codeBars"),
    @NamedQuery(name = "Oitm.findByVATLiable", query = "SELECT o FROM Oitm o WHERE o.vATLiable = :vATLiable"),
    @NamedQuery(name = "Oitm.findByPrchseItem", query = "SELECT o FROM Oitm o WHERE o.prchseItem = :prchseItem"),
    @NamedQuery(name = "Oitm.findBySellItem", query = "SELECT o FROM Oitm o WHERE o.sellItem = :sellItem"),
    @NamedQuery(name = "Oitm.findByInvntItem", query = "SELECT o FROM Oitm o WHERE o.invntItem = :invntItem"),
    @NamedQuery(name = "Oitm.findByOnHand", query = "SELECT o FROM Oitm o WHERE o.onHand = :onHand"),
    @NamedQuery(name = "Oitm.findByIsCommited", query = "SELECT o FROM Oitm o WHERE o.isCommited = :isCommited"),
    @NamedQuery(name = "Oitm.findByOnOrder", query = "SELECT o FROM Oitm o WHERE o.onOrder = :onOrder"),
    @NamedQuery(name = "Oitm.findByIncomeAcct", query = "SELECT o FROM Oitm o WHERE o.incomeAcct = :incomeAcct"),
    @NamedQuery(name = "Oitm.findByExmptIncom", query = "SELECT o FROM Oitm o WHERE o.exmptIncom = :exmptIncom"),
    @NamedQuery(name = "Oitm.findByMaxLevel", query = "SELECT o FROM Oitm o WHERE o.maxLevel = :maxLevel"),
    @NamedQuery(name = "Oitm.findByDfltWH", query = "SELECT o FROM Oitm o WHERE o.dfltWH = :dfltWH"),
    @NamedQuery(name = "Oitm.findByCardCode", query = "SELECT o FROM Oitm o WHERE o.cardCode = :cardCode"),
    @NamedQuery(name = "Oitm.findBySuppCatNum", query = "SELECT o FROM Oitm o WHERE o.suppCatNum = :suppCatNum"),
    @NamedQuery(name = "Oitm.findByBuyUnitMsr", query = "SELECT o FROM Oitm o WHERE o.buyUnitMsr = :buyUnitMsr"),
    @NamedQuery(name = "Oitm.findByNumInBuy", query = "SELECT o FROM Oitm o WHERE o.numInBuy = :numInBuy"),
    @NamedQuery(name = "Oitm.findByReorderQty", query = "SELECT o FROM Oitm o WHERE o.reorderQty = :reorderQty"),
    @NamedQuery(name = "Oitm.findByMinLevel", query = "SELECT o FROM Oitm o WHERE o.minLevel = :minLevel"),
    @NamedQuery(name = "Oitm.findByLstEvlPric", query = "SELECT o FROM Oitm o WHERE o.lstEvlPric = :lstEvlPric"),
    @NamedQuery(name = "Oitm.findByLstEvlDate", query = "SELECT o FROM Oitm o WHERE o.lstEvlDate = :lstEvlDate"),
    @NamedQuery(name = "Oitm.findByCustomPer", query = "SELECT o FROM Oitm o WHERE o.customPer = :customPer"),
    @NamedQuery(name = "Oitm.findByCanceled", query = "SELECT o FROM Oitm o WHERE o.canceled = :canceled"),
    @NamedQuery(name = "Oitm.findByMnufctTime", query = "SELECT o FROM Oitm o WHERE o.mnufctTime = :mnufctTime"),
    @NamedQuery(name = "Oitm.findByWholSlsTax", query = "SELECT o FROM Oitm o WHERE o.wholSlsTax = :wholSlsTax"),
    @NamedQuery(name = "Oitm.findByRetilrTax", query = "SELECT o FROM Oitm o WHERE o.retilrTax = :retilrTax"),
    @NamedQuery(name = "Oitm.findBySpcialDisc", query = "SELECT o FROM Oitm o WHERE o.spcialDisc = :spcialDisc"),
    @NamedQuery(name = "Oitm.findByDscountCod", query = "SELECT o FROM Oitm o WHERE o.dscountCod = :dscountCod"),
    @NamedQuery(name = "Oitm.findByTrackSales", query = "SELECT o FROM Oitm o WHERE o.trackSales = :trackSales"),
    @NamedQuery(name = "Oitm.findBySalUnitMsr", query = "SELECT o FROM Oitm o WHERE o.salUnitMsr = :salUnitMsr"),
    @NamedQuery(name = "Oitm.findByNumInSale", query = "SELECT o FROM Oitm o WHERE o.numInSale = :numInSale"),
    @NamedQuery(name = "Oitm.findByConsig", query = "SELECT o FROM Oitm o WHERE o.consig = :consig"),
    @NamedQuery(name = "Oitm.findByQueryGroup", query = "SELECT o FROM Oitm o WHERE o.queryGroup = :queryGroup"),
    @NamedQuery(name = "Oitm.findByCounted", query = "SELECT o FROM Oitm o WHERE o.counted = :counted"),
    @NamedQuery(name = "Oitm.findByOpenBlnc", query = "SELECT o FROM Oitm o WHERE o.openBlnc = :openBlnc"),
    @NamedQuery(name = "Oitm.findByEvalSystem", query = "SELECT o FROM Oitm o WHERE o.evalSystem = :evalSystem"),
    @NamedQuery(name = "Oitm.findByUserSign", query = "SELECT o FROM Oitm o WHERE o.userSign = :userSign"),
    @NamedQuery(name = "Oitm.findByFree", query = "SELECT o FROM Oitm o WHERE o.free = :free"),
    @NamedQuery(name = "Oitm.findByPicturName", query = "SELECT o FROM Oitm o WHERE o.picturName = :picturName"),
    @NamedQuery(name = "Oitm.findByTransfered", query = "SELECT o FROM Oitm o WHERE o.transfered = :transfered"),
    @NamedQuery(name = "Oitm.findByBlncTrnsfr", query = "SELECT o FROM Oitm o WHERE o.blncTrnsfr = :blncTrnsfr"),
    @NamedQuery(name = "Oitm.findBySerialNum", query = "SELECT o FROM Oitm o WHERE o.serialNum = :serialNum"),
    @NamedQuery(name = "Oitm.findByCommisPcnt", query = "SELECT o FROM Oitm o WHERE o.commisPcnt = :commisPcnt"),
    @NamedQuery(name = "Oitm.findByCommisSum", query = "SELECT o FROM Oitm o WHERE o.commisSum = :commisSum"),
    @NamedQuery(name = "Oitm.findByCommisGrp", query = "SELECT o FROM Oitm o WHERE o.commisGrp = :commisGrp"),
    @NamedQuery(name = "Oitm.findByTreeType", query = "SELECT o FROM Oitm o WHERE o.treeType = :treeType"),
    @NamedQuery(name = "Oitm.findByTreeQty", query = "SELECT o FROM Oitm o WHERE o.treeQty = :treeQty"),
    @NamedQuery(name = "Oitm.findByLastPurPrc", query = "SELECT o FROM Oitm o WHERE o.lastPurPrc = :lastPurPrc"),
    @NamedQuery(name = "Oitm.findByLastPurCur", query = "SELECT o FROM Oitm o WHERE o.lastPurCur = :lastPurCur"),
    @NamedQuery(name = "Oitm.findByLastPurDat", query = "SELECT o FROM Oitm o WHERE o.lastPurDat = :lastPurDat"),
    @NamedQuery(name = "Oitm.findByExitCur", query = "SELECT o FROM Oitm o WHERE o.exitCur = :exitCur"),
    @NamedQuery(name = "Oitm.findByExitPrice", query = "SELECT o FROM Oitm o WHERE o.exitPrice = :exitPrice"),
    @NamedQuery(name = "Oitm.findByExitWH", query = "SELECT o FROM Oitm o WHERE o.exitWH = :exitWH"),
    @NamedQuery(name = "Oitm.findByAssetItem", query = "SELECT o FROM Oitm o WHERE o.assetItem = :assetItem"),
    @NamedQuery(name = "Oitm.findByWasCounted", query = "SELECT o FROM Oitm o WHERE o.wasCounted = :wasCounted"),
    @NamedQuery(name = "Oitm.findByManSerNum", query = "SELECT o FROM Oitm o WHERE o.manSerNum = :manSerNum"),
    @NamedQuery(name = "Oitm.findBySHeight1", query = "SELECT o FROM Oitm o WHERE o.sHeight1 = :sHeight1"),
    @NamedQuery(name = "Oitm.findBySHght1Unit", query = "SELECT o FROM Oitm o WHERE o.sHght1Unit = :sHght1Unit"),
    @NamedQuery(name = "Oitm.findBySHeight2", query = "SELECT o FROM Oitm o WHERE o.sHeight2 = :sHeight2"),
    @NamedQuery(name = "Oitm.findBySHght2Unit", query = "SELECT o FROM Oitm o WHERE o.sHght2Unit = :sHght2Unit"),
    @NamedQuery(name = "Oitm.findBySWidth1", query = "SELECT o FROM Oitm o WHERE o.sWidth1 = :sWidth1"),
    @NamedQuery(name = "Oitm.findBySWdth1Unit", query = "SELECT o FROM Oitm o WHERE o.sWdth1Unit = :sWdth1Unit"),
    @NamedQuery(name = "Oitm.findBySWidth2", query = "SELECT o FROM Oitm o WHERE o.sWidth2 = :sWidth2"),
    @NamedQuery(name = "Oitm.findBySWdth2Unit", query = "SELECT o FROM Oitm o WHERE o.sWdth2Unit = :sWdth2Unit"),
    @NamedQuery(name = "Oitm.findBySLength1", query = "SELECT o FROM Oitm o WHERE o.sLength1 = :sLength1"),
    @NamedQuery(name = "Oitm.findBySLen1Unit", query = "SELECT o FROM Oitm o WHERE o.sLen1Unit = :sLen1Unit"),
    @NamedQuery(name = "Oitm.findBySlength2", query = "SELECT o FROM Oitm o WHERE o.slength2 = :slength2"),
    @NamedQuery(name = "Oitm.findBySLen2Unit", query = "SELECT o FROM Oitm o WHERE o.sLen2Unit = :sLen2Unit"),
    @NamedQuery(name = "Oitm.findBySVolume", query = "SELECT o FROM Oitm o WHERE o.sVolume = :sVolume"),
    @NamedQuery(name = "Oitm.findBySVolUnit", query = "SELECT o FROM Oitm o WHERE o.sVolUnit = :sVolUnit"),
    @NamedQuery(name = "Oitm.findBySWeight1", query = "SELECT o FROM Oitm o WHERE o.sWeight1 = :sWeight1"),
    @NamedQuery(name = "Oitm.findBySWght1Unit", query = "SELECT o FROM Oitm o WHERE o.sWght1Unit = :sWght1Unit"),
    @NamedQuery(name = "Oitm.findBySWeight2", query = "SELECT o FROM Oitm o WHERE o.sWeight2 = :sWeight2"),
    @NamedQuery(name = "Oitm.findBySWght2Unit", query = "SELECT o FROM Oitm o WHERE o.sWght2Unit = :sWght2Unit"),
    @NamedQuery(name = "Oitm.findByBHeight1", query = "SELECT o FROM Oitm o WHERE o.bHeight1 = :bHeight1"),
    @NamedQuery(name = "Oitm.findByBHght1Unit", query = "SELECT o FROM Oitm o WHERE o.bHght1Unit = :bHght1Unit"),
    @NamedQuery(name = "Oitm.findByBHeight2", query = "SELECT o FROM Oitm o WHERE o.bHeight2 = :bHeight2"),
    @NamedQuery(name = "Oitm.findByBHght2Unit", query = "SELECT o FROM Oitm o WHERE o.bHght2Unit = :bHght2Unit"),
    @NamedQuery(name = "Oitm.findByBWidth1", query = "SELECT o FROM Oitm o WHERE o.bWidth1 = :bWidth1"),
    @NamedQuery(name = "Oitm.findByBWdth1Unit", query = "SELECT o FROM Oitm o WHERE o.bWdth1Unit = :bWdth1Unit"),
    @NamedQuery(name = "Oitm.findByBWidth2", query = "SELECT o FROM Oitm o WHERE o.bWidth2 = :bWidth2"),
    @NamedQuery(name = "Oitm.findByBWdth2Unit", query = "SELECT o FROM Oitm o WHERE o.bWdth2Unit = :bWdth2Unit"),
    @NamedQuery(name = "Oitm.findByBLength1", query = "SELECT o FROM Oitm o WHERE o.bLength1 = :bLength1"),
    @NamedQuery(name = "Oitm.findByBLen1Unit", query = "SELECT o FROM Oitm o WHERE o.bLen1Unit = :bLen1Unit"),
    @NamedQuery(name = "Oitm.findByBlength2", query = "SELECT o FROM Oitm o WHERE o.blength2 = :blength2"),
    @NamedQuery(name = "Oitm.findByBLen2Unit", query = "SELECT o FROM Oitm o WHERE o.bLen2Unit = :bLen2Unit"),
    @NamedQuery(name = "Oitm.findByBVolume", query = "SELECT o FROM Oitm o WHERE o.bVolume = :bVolume"),
    @NamedQuery(name = "Oitm.findByBVolUnit", query = "SELECT o FROM Oitm o WHERE o.bVolUnit = :bVolUnit"),
    @NamedQuery(name = "Oitm.findByBWeight1", query = "SELECT o FROM Oitm o WHERE o.bWeight1 = :bWeight1"),
    @NamedQuery(name = "Oitm.findByBWght1Unit", query = "SELECT o FROM Oitm o WHERE o.bWght1Unit = :bWght1Unit"),
    @NamedQuery(name = "Oitm.findByBWeight2", query = "SELECT o FROM Oitm o WHERE o.bWeight2 = :bWeight2"),
    @NamedQuery(name = "Oitm.findByBWght2Unit", query = "SELECT o FROM Oitm o WHERE o.bWght2Unit = :bWght2Unit"),
    @NamedQuery(name = "Oitm.findByFixCurrCms", query = "SELECT o FROM Oitm o WHERE o.fixCurrCms = :fixCurrCms"),
    @NamedQuery(name = "Oitm.findByFirmCode", query = "SELECT o FROM Oitm o WHERE o.firmCode = :firmCode"),
    @NamedQuery(name = "Oitm.findByLstSalDate", query = "SELECT o FROM Oitm o WHERE o.lstSalDate = :lstSalDate"),
    @NamedQuery(name = "Oitm.findByQryGroup1", query = "SELECT o FROM Oitm o WHERE o.qryGroup1 = :qryGroup1"),
    @NamedQuery(name = "Oitm.findByQryGroup2", query = "SELECT o FROM Oitm o WHERE o.qryGroup2 = :qryGroup2"),
    @NamedQuery(name = "Oitm.findByQryGroup3", query = "SELECT o FROM Oitm o WHERE o.qryGroup3 = :qryGroup3"),
    @NamedQuery(name = "Oitm.findByQryGroup4", query = "SELECT o FROM Oitm o WHERE o.qryGroup4 = :qryGroup4"),
    @NamedQuery(name = "Oitm.findByQryGroup5", query = "SELECT o FROM Oitm o WHERE o.qryGroup5 = :qryGroup5"),
    @NamedQuery(name = "Oitm.findByQryGroup6", query = "SELECT o FROM Oitm o WHERE o.qryGroup6 = :qryGroup6"),
    @NamedQuery(name = "Oitm.findByQryGroup7", query = "SELECT o FROM Oitm o WHERE o.qryGroup7 = :qryGroup7"),
    @NamedQuery(name = "Oitm.findByQryGroup8", query = "SELECT o FROM Oitm o WHERE o.qryGroup8 = :qryGroup8"),
    @NamedQuery(name = "Oitm.findByQryGroup9", query = "SELECT o FROM Oitm o WHERE o.qryGroup9 = :qryGroup9"),
    @NamedQuery(name = "Oitm.findByQryGroup10", query = "SELECT o FROM Oitm o WHERE o.qryGroup10 = :qryGroup10"),
    @NamedQuery(name = "Oitm.findByQryGroup11", query = "SELECT o FROM Oitm o WHERE o.qryGroup11 = :qryGroup11"),
    @NamedQuery(name = "Oitm.findByQryGroup12", query = "SELECT o FROM Oitm o WHERE o.qryGroup12 = :qryGroup12"),
    @NamedQuery(name = "Oitm.findByQryGroup13", query = "SELECT o FROM Oitm o WHERE o.qryGroup13 = :qryGroup13"),
    @NamedQuery(name = "Oitm.findByQryGroup14", query = "SELECT o FROM Oitm o WHERE o.qryGroup14 = :qryGroup14"),
    @NamedQuery(name = "Oitm.findByQryGroup15", query = "SELECT o FROM Oitm o WHERE o.qryGroup15 = :qryGroup15"),
    @NamedQuery(name = "Oitm.findByQryGroup16", query = "SELECT o FROM Oitm o WHERE o.qryGroup16 = :qryGroup16"),
    @NamedQuery(name = "Oitm.findByQryGroup17", query = "SELECT o FROM Oitm o WHERE o.qryGroup17 = :qryGroup17"),
    @NamedQuery(name = "Oitm.findByQryGroup18", query = "SELECT o FROM Oitm o WHERE o.qryGroup18 = :qryGroup18"),
    @NamedQuery(name = "Oitm.findByQryGroup19", query = "SELECT o FROM Oitm o WHERE o.qryGroup19 = :qryGroup19"),
    @NamedQuery(name = "Oitm.findByQryGroup20", query = "SELECT o FROM Oitm o WHERE o.qryGroup20 = :qryGroup20"),
    @NamedQuery(name = "Oitm.findByQryGroup21", query = "SELECT o FROM Oitm o WHERE o.qryGroup21 = :qryGroup21"),
    @NamedQuery(name = "Oitm.findByQryGroup22", query = "SELECT o FROM Oitm o WHERE o.qryGroup22 = :qryGroup22"),
    @NamedQuery(name = "Oitm.findByQryGroup23", query = "SELECT o FROM Oitm o WHERE o.qryGroup23 = :qryGroup23"),
    @NamedQuery(name = "Oitm.findByQryGroup24", query = "SELECT o FROM Oitm o WHERE o.qryGroup24 = :qryGroup24"),
    @NamedQuery(name = "Oitm.findByQryGroup25", query = "SELECT o FROM Oitm o WHERE o.qryGroup25 = :qryGroup25"),
    @NamedQuery(name = "Oitm.findByQryGroup26", query = "SELECT o FROM Oitm o WHERE o.qryGroup26 = :qryGroup26"),
    @NamedQuery(name = "Oitm.findByQryGroup27", query = "SELECT o FROM Oitm o WHERE o.qryGroup27 = :qryGroup27"),
    @NamedQuery(name = "Oitm.findByQryGroup28", query = "SELECT o FROM Oitm o WHERE o.qryGroup28 = :qryGroup28"),
    @NamedQuery(name = "Oitm.findByQryGroup29", query = "SELECT o FROM Oitm o WHERE o.qryGroup29 = :qryGroup29"),
    @NamedQuery(name = "Oitm.findByQryGroup30", query = "SELECT o FROM Oitm o WHERE o.qryGroup30 = :qryGroup30"),
    @NamedQuery(name = "Oitm.findByQryGroup31", query = "SELECT o FROM Oitm o WHERE o.qryGroup31 = :qryGroup31"),
    @NamedQuery(name = "Oitm.findByQryGroup32", query = "SELECT o FROM Oitm o WHERE o.qryGroup32 = :qryGroup32"),
    @NamedQuery(name = "Oitm.findByQryGroup33", query = "SELECT o FROM Oitm o WHERE o.qryGroup33 = :qryGroup33"),
    @NamedQuery(name = "Oitm.findByQryGroup34", query = "SELECT o FROM Oitm o WHERE o.qryGroup34 = :qryGroup34"),
    @NamedQuery(name = "Oitm.findByQryGroup35", query = "SELECT o FROM Oitm o WHERE o.qryGroup35 = :qryGroup35"),
    @NamedQuery(name = "Oitm.findByQryGroup36", query = "SELECT o FROM Oitm o WHERE o.qryGroup36 = :qryGroup36"),
    @NamedQuery(name = "Oitm.findByQryGroup37", query = "SELECT o FROM Oitm o WHERE o.qryGroup37 = :qryGroup37"),
    @NamedQuery(name = "Oitm.findByQryGroup38", query = "SELECT o FROM Oitm o WHERE o.qryGroup38 = :qryGroup38"),
    @NamedQuery(name = "Oitm.findByQryGroup39", query = "SELECT o FROM Oitm o WHERE o.qryGroup39 = :qryGroup39"),
    @NamedQuery(name = "Oitm.findByQryGroup40", query = "SELECT o FROM Oitm o WHERE o.qryGroup40 = :qryGroup40"),
    @NamedQuery(name = "Oitm.findByQryGroup41", query = "SELECT o FROM Oitm o WHERE o.qryGroup41 = :qryGroup41"),
    @NamedQuery(name = "Oitm.findByQryGroup42", query = "SELECT o FROM Oitm o WHERE o.qryGroup42 = :qryGroup42"),
    @NamedQuery(name = "Oitm.findByQryGroup43", query = "SELECT o FROM Oitm o WHERE o.qryGroup43 = :qryGroup43"),
    @NamedQuery(name = "Oitm.findByQryGroup44", query = "SELECT o FROM Oitm o WHERE o.qryGroup44 = :qryGroup44"),
    @NamedQuery(name = "Oitm.findByQryGroup45", query = "SELECT o FROM Oitm o WHERE o.qryGroup45 = :qryGroup45"),
    @NamedQuery(name = "Oitm.findByQryGroup46", query = "SELECT o FROM Oitm o WHERE o.qryGroup46 = :qryGroup46"),
    @NamedQuery(name = "Oitm.findByQryGroup47", query = "SELECT o FROM Oitm o WHERE o.qryGroup47 = :qryGroup47"),
    @NamedQuery(name = "Oitm.findByQryGroup48", query = "SELECT o FROM Oitm o WHERE o.qryGroup48 = :qryGroup48"),
    @NamedQuery(name = "Oitm.findByQryGroup49", query = "SELECT o FROM Oitm o WHERE o.qryGroup49 = :qryGroup49"),
    @NamedQuery(name = "Oitm.findByQryGroup50", query = "SELECT o FROM Oitm o WHERE o.qryGroup50 = :qryGroup50"),
    @NamedQuery(name = "Oitm.findByQryGroup51", query = "SELECT o FROM Oitm o WHERE o.qryGroup51 = :qryGroup51"),
    @NamedQuery(name = "Oitm.findByQryGroup52", query = "SELECT o FROM Oitm o WHERE o.qryGroup52 = :qryGroup52"),
    @NamedQuery(name = "Oitm.findByQryGroup53", query = "SELECT o FROM Oitm o WHERE o.qryGroup53 = :qryGroup53"),
    @NamedQuery(name = "Oitm.findByQryGroup54", query = "SELECT o FROM Oitm o WHERE o.qryGroup54 = :qryGroup54"),
    @NamedQuery(name = "Oitm.findByQryGroup55", query = "SELECT o FROM Oitm o WHERE o.qryGroup55 = :qryGroup55"),
    @NamedQuery(name = "Oitm.findByQryGroup56", query = "SELECT o FROM Oitm o WHERE o.qryGroup56 = :qryGroup56"),
    @NamedQuery(name = "Oitm.findByQryGroup57", query = "SELECT o FROM Oitm o WHERE o.qryGroup57 = :qryGroup57"),
    @NamedQuery(name = "Oitm.findByQryGroup58", query = "SELECT o FROM Oitm o WHERE o.qryGroup58 = :qryGroup58"),
    @NamedQuery(name = "Oitm.findByQryGroup59", query = "SELECT o FROM Oitm o WHERE o.qryGroup59 = :qryGroup59"),
    @NamedQuery(name = "Oitm.findByQryGroup60", query = "SELECT o FROM Oitm o WHERE o.qryGroup60 = :qryGroup60"),
    @NamedQuery(name = "Oitm.findByQryGroup61", query = "SELECT o FROM Oitm o WHERE o.qryGroup61 = :qryGroup61"),
    @NamedQuery(name = "Oitm.findByQryGroup62", query = "SELECT o FROM Oitm o WHERE o.qryGroup62 = :qryGroup62"),
    @NamedQuery(name = "Oitm.findByQryGroup63", query = "SELECT o FROM Oitm o WHERE o.qryGroup63 = :qryGroup63"),
    @NamedQuery(name = "Oitm.findByQryGroup64", query = "SELECT o FROM Oitm o WHERE o.qryGroup64 = :qryGroup64"),
    @NamedQuery(name = "Oitm.findByCreateDate", query = "SELECT o FROM Oitm o WHERE o.createDate = :createDate"),
    @NamedQuery(name = "Oitm.findByUpdateDate", query = "SELECT o FROM Oitm o WHERE o.updateDate = :updateDate"),
    @NamedQuery(name = "Oitm.findByExportCode", query = "SELECT o FROM Oitm o WHERE o.exportCode = :exportCode"),
    @NamedQuery(name = "Oitm.findBySalFactor1", query = "SELECT o FROM Oitm o WHERE o.salFactor1 = :salFactor1"),
    @NamedQuery(name = "Oitm.findBySalFactor2", query = "SELECT o FROM Oitm o WHERE o.salFactor2 = :salFactor2"),
    @NamedQuery(name = "Oitm.findBySalFactor3", query = "SELECT o FROM Oitm o WHERE o.salFactor3 = :salFactor3"),
    @NamedQuery(name = "Oitm.findBySalFactor4", query = "SELECT o FROM Oitm o WHERE o.salFactor4 = :salFactor4"),
    @NamedQuery(name = "Oitm.findByPurFactor1", query = "SELECT o FROM Oitm o WHERE o.purFactor1 = :purFactor1"),
    @NamedQuery(name = "Oitm.findByPurFactor2", query = "SELECT o FROM Oitm o WHERE o.purFactor2 = :purFactor2"),
    @NamedQuery(name = "Oitm.findByPurFactor3", query = "SELECT o FROM Oitm o WHERE o.purFactor3 = :purFactor3"),
    @NamedQuery(name = "Oitm.findByPurFactor4", query = "SELECT o FROM Oitm o WHERE o.purFactor4 = :purFactor4"),
    @NamedQuery(name = "Oitm.findBySalFormula", query = "SELECT o FROM Oitm o WHERE o.salFormula = :salFormula"),
    @NamedQuery(name = "Oitm.findByPurFormula", query = "SELECT o FROM Oitm o WHERE o.purFormula = :purFormula"),
    @NamedQuery(name = "Oitm.findByVatGroupPu", query = "SELECT o FROM Oitm o WHERE o.vatGroupPu = :vatGroupPu"),
    @NamedQuery(name = "Oitm.findByAvgPrice", query = "SELECT o FROM Oitm o WHERE o.avgPrice = :avgPrice"),
    @NamedQuery(name = "Oitm.findByPurPackMsr", query = "SELECT o FROM Oitm o WHERE o.purPackMsr = :purPackMsr"),
    @NamedQuery(name = "Oitm.findByPurPackUn", query = "SELECT o FROM Oitm o WHERE o.purPackUn = :purPackUn"),
    @NamedQuery(name = "Oitm.findBySalPackMsr", query = "SELECT o FROM Oitm o WHERE o.salPackMsr = :salPackMsr"),
    @NamedQuery(name = "Oitm.findBySalPackUn", query = "SELECT o FROM Oitm o WHERE o.salPackUn = :salPackUn"),
    @NamedQuery(name = "Oitm.findBySCNCounter", query = "SELECT o FROM Oitm o WHERE o.sCNCounter = :sCNCounter"),
    @NamedQuery(name = "Oitm.findByManBtchNum", query = "SELECT o FROM Oitm o WHERE o.manBtchNum = :manBtchNum"),
    @NamedQuery(name = "Oitm.findByManOutOnly", query = "SELECT o FROM Oitm o WHERE o.manOutOnly = :manOutOnly"),
    @NamedQuery(name = "Oitm.findByDataSource", query = "SELECT o FROM Oitm o WHERE o.dataSource = :dataSource"),
    @NamedQuery(name = "Oitm.findByValidFor", query = "SELECT o FROM Oitm o WHERE o.validFor = :validFor"),
    @NamedQuery(name = "Oitm.findByValidFrom", query = "SELECT o FROM Oitm o WHERE o.validFrom = :validFrom"),
    @NamedQuery(name = "Oitm.findByValidTo", query = "SELECT o FROM Oitm o WHERE o.validTo = :validTo"),
    @NamedQuery(name = "Oitm.findByFrozenFor", query = "SELECT o FROM Oitm o WHERE o.frozenFor = :frozenFor"),
    @NamedQuery(name = "Oitm.findByFrozenFrom", query = "SELECT o FROM Oitm o WHERE o.frozenFrom = :frozenFrom"),
    @NamedQuery(name = "Oitm.findByFrozenTo", query = "SELECT o FROM Oitm o WHERE o.frozenTo = :frozenTo"),
    @NamedQuery(name = "Oitm.findByBlockOut", query = "SELECT o FROM Oitm o WHERE o.blockOut = :blockOut"),
    @NamedQuery(name = "Oitm.findByValidComm", query = "SELECT o FROM Oitm o WHERE o.validComm = :validComm"),
    @NamedQuery(name = "Oitm.findByFrozenComm", query = "SELECT o FROM Oitm o WHERE o.frozenComm = :frozenComm"),
    @NamedQuery(name = "Oitm.findByLogInstanc", query = "SELECT o FROM Oitm o WHERE o.logInstanc = :logInstanc"),
    @NamedQuery(name = "Oitm.findByObjType", query = "SELECT o FROM Oitm o WHERE o.objType = :objType"),
    @NamedQuery(name = "Oitm.findBySww", query = "SELECT o FROM Oitm o WHERE o.sww = :sww"),
    @NamedQuery(name = "Oitm.findByDeleted", query = "SELECT o FROM Oitm o WHERE o.deleted = :deleted"),
    @NamedQuery(name = "Oitm.findByDocEntry", query = "SELECT o FROM Oitm o WHERE o.docEntry = :docEntry"),
    @NamedQuery(name = "Oitm.findByExpensAcct", query = "SELECT o FROM Oitm o WHERE o.expensAcct = :expensAcct"),
    @NamedQuery(name = "Oitm.findByFrgnInAcct", query = "SELECT o FROM Oitm o WHERE o.frgnInAcct = :frgnInAcct"),
    @NamedQuery(name = "Oitm.findByShipType", query = "SELECT o FROM Oitm o WHERE o.shipType = :shipType"),
    @NamedQuery(name = "Oitm.findByGLMethod", query = "SELECT o FROM Oitm o WHERE o.gLMethod = :gLMethod"),
    @NamedQuery(name = "Oitm.findByECInAcct", query = "SELECT o FROM Oitm o WHERE o.eCInAcct = :eCInAcct"),
    @NamedQuery(name = "Oitm.findByFrgnExpAcc", query = "SELECT o FROM Oitm o WHERE o.frgnExpAcc = :frgnExpAcc"),
    @NamedQuery(name = "Oitm.findByECExpAcc", query = "SELECT o FROM Oitm o WHERE o.eCExpAcc = :eCExpAcc"),
    @NamedQuery(name = "Oitm.findByTaxType", query = "SELECT o FROM Oitm o WHERE o.taxType = :taxType"),
    @NamedQuery(name = "Oitm.findByByWh", query = "SELECT o FROM Oitm o WHERE o.byWh = :byWh"),
    @NamedQuery(name = "Oitm.findByWTLiable", query = "SELECT o FROM Oitm o WHERE o.wTLiable = :wTLiable"),
    @NamedQuery(name = "Oitm.findByItemType", query = "SELECT o FROM Oitm o WHERE o.itemType = :itemType"),
    @NamedQuery(name = "Oitm.findByWarrntTmpl", query = "SELECT o FROM Oitm o WHERE o.warrntTmpl = :warrntTmpl"),
    @NamedQuery(name = "Oitm.findByBaseUnit", query = "SELECT o FROM Oitm o WHERE o.baseUnit = :baseUnit"),
    @NamedQuery(name = "Oitm.findByCountryOrg", query = "SELECT o FROM Oitm o WHERE o.countryOrg = :countryOrg"),
    @NamedQuery(name = "Oitm.findByStockValue", query = "SELECT o FROM Oitm o WHERE o.stockValue = :stockValue"),
    @NamedQuery(name = "Oitm.findByPhantom", query = "SELECT o FROM Oitm o WHERE o.phantom = :phantom"),
    @NamedQuery(name = "Oitm.findByIssueMthd", query = "SELECT o FROM Oitm o WHERE o.issueMthd = :issueMthd"),
    @NamedQuery(name = "Oitm.findByFree1", query = "SELECT o FROM Oitm o WHERE o.free1 = :free1"),
    @NamedQuery(name = "Oitm.findByPricingPrc", query = "SELECT o FROM Oitm o WHERE o.pricingPrc = :pricingPrc"),
    @NamedQuery(name = "Oitm.findByMngMethod", query = "SELECT o FROM Oitm o WHERE o.mngMethod = :mngMethod"),
    @NamedQuery(name = "Oitm.findByReorderPnt", query = "SELECT o FROM Oitm o WHERE o.reorderPnt = :reorderPnt"),
    @NamedQuery(name = "Oitm.findByInvntryUom", query = "SELECT o FROM Oitm o WHERE o.invntryUom = :invntryUom"),
    @NamedQuery(name = "Oitm.findByPlaningSys", query = "SELECT o FROM Oitm o WHERE o.planingSys = :planingSys"),
    @NamedQuery(name = "Oitm.findByPrcrmntMtd", query = "SELECT o FROM Oitm o WHERE o.prcrmntMtd = :prcrmntMtd"),
    @NamedQuery(name = "Oitm.findByOrdrIntrvl", query = "SELECT o FROM Oitm o WHERE o.ordrIntrvl = :ordrIntrvl"),
    @NamedQuery(name = "Oitm.findByOrdrMulti", query = "SELECT o FROM Oitm o WHERE o.ordrMulti = :ordrMulti"),
    @NamedQuery(name = "Oitm.findByMinOrdrQty", query = "SELECT o FROM Oitm o WHERE o.minOrdrQty = :minOrdrQty"),
    @NamedQuery(name = "Oitm.findByLeadTime", query = "SELECT o FROM Oitm o WHERE o.leadTime = :leadTime"),
    @NamedQuery(name = "Oitm.findByIndirctTax", query = "SELECT o FROM Oitm o WHERE o.indirctTax = :indirctTax"),
    @NamedQuery(name = "Oitm.findByTaxCodeAR", query = "SELECT o FROM Oitm o WHERE o.taxCodeAR = :taxCodeAR"),
    @NamedQuery(name = "Oitm.findByTaxCodeAP", query = "SELECT o FROM Oitm o WHERE o.taxCodeAP = :taxCodeAP"),
    @NamedQuery(name = "Oitm.findByOSvcCode", query = "SELECT o FROM Oitm o WHERE o.oSvcCode = :oSvcCode"),
    @NamedQuery(name = "Oitm.findByISvcCode", query = "SELECT o FROM Oitm o WHERE o.iSvcCode = :iSvcCode"),
    @NamedQuery(name = "Oitm.findByServiceGrp", query = "SELECT o FROM Oitm o WHERE o.serviceGrp = :serviceGrp"),
    @NamedQuery(name = "Oitm.findByNCMCode", query = "SELECT o FROM Oitm o WHERE o.nCMCode = :nCMCode"),
    @NamedQuery(name = "Oitm.findByMatType", query = "SELECT o FROM Oitm o WHERE o.matType = :matType"),
    @NamedQuery(name = "Oitm.findByMatGrp", query = "SELECT o FROM Oitm o WHERE o.matGrp = :matGrp"),
    @NamedQuery(name = "Oitm.findByProductSrc", query = "SELECT o FROM Oitm o WHERE o.productSrc = :productSrc"),
    @NamedQuery(name = "Oitm.findByServiceCtg", query = "SELECT o FROM Oitm o WHERE o.serviceCtg = :serviceCtg"),
    @NamedQuery(name = "Oitm.findByItemClass", query = "SELECT o FROM Oitm o WHERE o.itemClass = :itemClass"),
    @NamedQuery(name = "Oitm.findByExcisable", query = "SELECT o FROM Oitm o WHERE o.excisable = :excisable"),
    @NamedQuery(name = "Oitm.findByChapterID", query = "SELECT o FROM Oitm o WHERE o.chapterID = :chapterID"),
    @NamedQuery(name = "Oitm.findByNotifyASN", query = "SELECT o FROM Oitm o WHERE o.notifyASN = :notifyASN"),
    @NamedQuery(name = "Oitm.findByProAssNum", query = "SELECT o FROM Oitm o WHERE o.proAssNum = :proAssNum"),
    @NamedQuery(name = "Oitm.findByAssblValue", query = "SELECT o FROM Oitm o WHERE o.assblValue = :assblValue"),
    @NamedQuery(name = "Oitm.findByDNFEntry", query = "SELECT o FROM Oitm o WHERE o.dNFEntry = :dNFEntry"),
    @NamedQuery(name = "Oitm.findByUserSign2", query = "SELECT o FROM Oitm o WHERE o.userSign2 = :userSign2"),
    @NamedQuery(name = "Oitm.findBySpec", query = "SELECT o FROM Oitm o WHERE o.spec = :spec"),
    @NamedQuery(name = "Oitm.findByTaxCtg", query = "SELECT o FROM Oitm o WHERE o.taxCtg = :taxCtg"),
    @NamedQuery(name = "Oitm.findBySeries", query = "SELECT o FROM Oitm o WHERE o.series = :series"),
    @NamedQuery(name = "Oitm.findByNumber", query = "SELECT o FROM Oitm o WHERE o.number = :number"),
    @NamedQuery(name = "Oitm.findByFuelCode", query = "SELECT o FROM Oitm o WHERE o.fuelCode = :fuelCode"),
    @NamedQuery(name = "Oitm.findByBeverTblC", query = "SELECT o FROM Oitm o WHERE o.beverTblC = :beverTblC"),
    @NamedQuery(name = "Oitm.findByBeverGrpC", query = "SELECT o FROM Oitm o WHERE o.beverGrpC = :beverGrpC"),
    @NamedQuery(name = "Oitm.findByBeverTM", query = "SELECT o FROM Oitm o WHERE o.beverTM = :beverTM"),
    @NamedQuery(name = "Oitm.findByAtcEntry", query = "SELECT o FROM Oitm o WHERE o.atcEntry = :atcEntry"),
    @NamedQuery(name = "Oitm.findByToleranDay", query = "SELECT o FROM Oitm o WHERE o.toleranDay = :toleranDay"),
    @NamedQuery(name = "Oitm.findByUgpEntry", query = "SELECT o FROM Oitm o WHERE o.ugpEntry = :ugpEntry"),
    @NamedQuery(name = "Oitm.findByPUoMEntry", query = "SELECT o FROM Oitm o WHERE o.pUoMEntry = :pUoMEntry"),
    @NamedQuery(name = "Oitm.findBySUoMEntry", query = "SELECT o FROM Oitm o WHERE o.sUoMEntry = :sUoMEntry"),
    @NamedQuery(name = "Oitm.findByIUoMEntry", query = "SELECT o FROM Oitm o WHERE o.iUoMEntry = :iUoMEntry"),
    @NamedQuery(name = "Oitm.findByIssuePriBy", query = "SELECT o FROM Oitm o WHERE o.issuePriBy = :issuePriBy"),
    @NamedQuery(name = "Oitm.findByAssetClass", query = "SELECT o FROM Oitm o WHERE o.assetClass = :assetClass"),
    @NamedQuery(name = "Oitm.findByAssetGroup", query = "SELECT o FROM Oitm o WHERE o.assetGroup = :assetGroup"),
    @NamedQuery(name = "Oitm.findByInventryNo", query = "SELECT o FROM Oitm o WHERE o.inventryNo = :inventryNo"),
    @NamedQuery(name = "Oitm.findByTechnician", query = "SELECT o FROM Oitm o WHERE o.technician = :technician"),
    @NamedQuery(name = "Oitm.findByEmployee", query = "SELECT o FROM Oitm o WHERE o.employee = :employee"),
    @NamedQuery(name = "Oitm.findByLocation", query = "SELECT o FROM Oitm o WHERE o.location = :location"),
    @NamedQuery(name = "Oitm.findByStatAsset", query = "SELECT o FROM Oitm o WHERE o.statAsset = :statAsset"),
    @NamedQuery(name = "Oitm.findByCession", query = "SELECT o FROM Oitm o WHERE o.cession = :cession"),
    @NamedQuery(name = "Oitm.findByDeacAftUL", query = "SELECT o FROM Oitm o WHERE o.deacAftUL = :deacAftUL"),
    @NamedQuery(name = "Oitm.findByAsstStatus", query = "SELECT o FROM Oitm o WHERE o.asstStatus = :asstStatus"),
    @NamedQuery(name = "Oitm.findByCapDate", query = "SELECT o FROM Oitm o WHERE o.capDate = :capDate"),
    @NamedQuery(name = "Oitm.findByAcqDate", query = "SELECT o FROM Oitm o WHERE o.acqDate = :acqDate"),
    @NamedQuery(name = "Oitm.findByRetDate", query = "SELECT o FROM Oitm o WHERE o.retDate = :retDate"),
    @NamedQuery(name = "Oitm.findByGLPickMeth", query = "SELECT o FROM Oitm o WHERE o.gLPickMeth = :gLPickMeth"),
    @NamedQuery(name = "Oitm.findByNoDiscount", query = "SELECT o FROM Oitm o WHERE o.noDiscount = :noDiscount"),
    @NamedQuery(name = "Oitm.findByMgrByQty", query = "SELECT o FROM Oitm o WHERE o.mgrByQty = :mgrByQty"),
    @NamedQuery(name = "Oitm.findByAssetRmk1", query = "SELECT o FROM Oitm o WHERE o.assetRmk1 = :assetRmk1"),
    @NamedQuery(name = "Oitm.findByAssetRmk2", query = "SELECT o FROM Oitm o WHERE o.assetRmk2 = :assetRmk2"),
    @NamedQuery(name = "Oitm.findByAssetAmnt1", query = "SELECT o FROM Oitm o WHERE o.assetAmnt1 = :assetAmnt1"),
    @NamedQuery(name = "Oitm.findByAssetAmnt2", query = "SELECT o FROM Oitm o WHERE o.assetAmnt2 = :assetAmnt2"),
    @NamedQuery(name = "Oitm.findByDeprGroup", query = "SELECT o FROM Oitm o WHERE o.deprGroup = :deprGroup"),
    @NamedQuery(name = "Oitm.findByAssetSerNo", query = "SELECT o FROM Oitm o WHERE o.assetSerNo = :assetSerNo"),
    @NamedQuery(name = "Oitm.findByCntUnitMsr", query = "SELECT o FROM Oitm o WHERE o.cntUnitMsr = :cntUnitMsr"),
    @NamedQuery(name = "Oitm.findByNumInCnt", query = "SELECT o FROM Oitm o WHERE o.numInCnt = :numInCnt"),
    @NamedQuery(name = "Oitm.findByINUoMEntry", query = "SELECT o FROM Oitm o WHERE o.iNUoMEntry = :iNUoMEntry"),
    @NamedQuery(name = "Oitm.findByOneBOneRec", query = "SELECT o FROM Oitm o WHERE o.oneBOneRec = :oneBOneRec"),
    @NamedQuery(name = "Oitm.findByRuleCode", query = "SELECT o FROM Oitm o WHERE o.ruleCode = :ruleCode"),
    @NamedQuery(name = "Oitm.findByScsCode", query = "SELECT o FROM Oitm o WHERE o.scsCode = :scsCode"),
    @NamedQuery(name = "Oitm.findBySpProdType", query = "SELECT o FROM Oitm o WHERE o.spProdType = :spProdType"),
    @NamedQuery(name = "Oitm.findByIWeight1", query = "SELECT o FROM Oitm o WHERE o.iWeight1 = :iWeight1"),
    @NamedQuery(name = "Oitm.findByIWght1Unit", query = "SELECT o FROM Oitm o WHERE o.iWght1Unit = :iWght1Unit"),
    @NamedQuery(name = "Oitm.findByIWeight2", query = "SELECT o FROM Oitm o WHERE o.iWeight2 = :iWeight2"),
    @NamedQuery(name = "Oitm.findByIWght2Unit", query = "SELECT o FROM Oitm o WHERE o.iWght2Unit = :iWght2Unit"),
    @NamedQuery(name = "Oitm.findByCompoWH", query = "SELECT o FROM Oitm o WHERE o.compoWH = :compoWH"),
    @NamedQuery(name = "Oitm.findByCreateTS", query = "SELECT o FROM Oitm o WHERE o.createTS = :createTS"),
    @NamedQuery(name = "Oitm.findByUpdateTS", query = "SELECT o FROM Oitm o WHERE o.updateTS = :updateTS"),
    @NamedQuery(name = "Oitm.findByVirtAstItm", query = "SELECT o FROM Oitm o WHERE o.virtAstItm = :virtAstItm"),
    @NamedQuery(name = "Oitm.findBySouVirAsst", query = "SELECT o FROM Oitm o WHERE o.souVirAsst = :souVirAsst"),
    @NamedQuery(name = "Oitm.findByInCostRoll", query = "SELECT o FROM Oitm o WHERE o.inCostRoll = :inCostRoll"),
    @NamedQuery(name = "Oitm.findByPrdStdCst", query = "SELECT o FROM Oitm o WHERE o.prdStdCst = :prdStdCst"),
    @NamedQuery(name = "Oitm.findByEnAstSeri", query = "SELECT o FROM Oitm o WHERE o.enAstSeri = :enAstSeri"),
    @NamedQuery(name = "Oitm.findByLinkRsc", query = "SELECT o FROM Oitm o WHERE o.linkRsc = :linkRsc"),
    @NamedQuery(name = "Oitm.findByOnHldPert", query = "SELECT o FROM Oitm o WHERE o.onHldPert = :onHldPert"),
    @NamedQuery(name = "Oitm.findByOnHldLimt", query = "SELECT o FROM Oitm o WHERE o.onHldLimt = :onHldLimt"),
    @NamedQuery(name = "Oitm.findByGSTRelevnt", query = "SELECT o FROM Oitm o WHERE o.gSTRelevnt = :gSTRelevnt"),
    @NamedQuery(name = "Oitm.findBySACEntry", query = "SELECT o FROM Oitm o WHERE o.sACEntry = :sACEntry"),
    @NamedQuery(name = "Oitm.findByGstTaxCtg", query = "SELECT o FROM Oitm o WHERE o.gstTaxCtg = :gstTaxCtg"),
    @NamedQuery(name = "Oitm.findByUIGroup", query = "SELECT o FROM Oitm o WHERE o.uIGroup = :uIGroup"),
    @NamedQuery(name = "Oitm.findByUSubgr", query = "SELECT o FROM Oitm o WHERE o.uSubgr = :uSubgr"),
    @NamedQuery(name = "Oitm.findByURdcode", query = "SELECT o FROM Oitm o WHERE o.uRdcode = :uRdcode"),
    @NamedQuery(name = "Oitm.findByUIGroupName", query = "SELECT o FROM Oitm o WHERE o.uIGroupName = :uIGroupName"),
    @NamedQuery(name = "Oitm.findByUSUBGRName", query = "SELECT o FROM Oitm o WHERE o.uSUBGRName = :uSUBGRName"),
    @NamedQuery(name = "Oitm.findByUProductBranch", query = "SELECT o FROM Oitm o WHERE o.uProductBranch = :uProductBranch"),
    @NamedQuery(name = "Oitm.findByUProductGroup", query = "SELECT o FROM Oitm o WHERE o.uProductGroup = :uProductGroup"),
    @NamedQuery(name = "Oitm.findByUForcast", query = "SELECT o FROM Oitm o WHERE o.uForcast = :uForcast"),
    @NamedQuery(name = "Oitm.findByUShortName", query = "SELECT o FROM Oitm o WHERE o.uShortName = :uShortName"),
    @NamedQuery(name = "Oitm.findByUDGroup", query = "SELECT o FROM Oitm o WHERE o.uDGroup = :uDGroup"),
    @NamedQuery(name = "Oitm.findByUDGroupName", query = "SELECT o FROM Oitm o WHERE o.uDGroupName = :uDGroupName"),
    @NamedQuery(name = "Oitm.findByUPackage", query = "SELECT o FROM Oitm o WHERE o.uPackage = :uPackage"),
    @NamedQuery(name = "Oitm.findByUPartNumber", query = "SELECT o FROM Oitm o WHERE o.uPartNumber = :uPartNumber")})
public class Oitm implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ItemCode")
    private String itemCode;
    @Column(name = "ItemName")
    private String itemName;
    @Column(name = "FrgnName")
    private String frgnName;
    @Column(name = "ItmsGrpCod")
    private Short itmsGrpCod;
    @Column(name = "CstGrpCode")
    private Short cstGrpCode;
    @Column(name = "VatGourpSa")
    private String vatGourpSa;
    @Column(name = "CodeBars")
    private String codeBars;
    @Column(name = "VATLiable")
    private Character vATLiable;
    @Column(name = "PrchseItem")
    private Character prchseItem;
    @Column(name = "SellItem")
    private Character sellItem;
    @Column(name = "InvntItem")
    private Character invntItem;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "OnHand")
    private BigDecimal onHand;
    @Column(name = "IsCommited")
    private BigDecimal isCommited;
    @Column(name = "OnOrder")
    private BigDecimal onOrder;
    @Column(name = "IncomeAcct")
    private String incomeAcct;
    @Column(name = "ExmptIncom")
    private String exmptIncom;
    @Column(name = "MaxLevel")
    private BigDecimal maxLevel;
    @Column(name = "DfltWH")
    private String dfltWH;
    @Column(name = "CardCode")
    private String cardCode;
    @Column(name = "SuppCatNum")
    private String suppCatNum;
    @Column(name = "BuyUnitMsr")
    private String buyUnitMsr;
    @Column(name = "NumInBuy")
    private BigDecimal numInBuy;
    @Column(name = "ReorderQty")
    private BigDecimal reorderQty;
    @Column(name = "MinLevel")
    private BigDecimal minLevel;
    @Column(name = "LstEvlPric")
    private BigDecimal lstEvlPric;
    @Column(name = "LstEvlDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lstEvlDate;
    @Column(name = "CustomPer")
    private BigDecimal customPer;
    @Column(name = "Canceled")
    private Character canceled;
    @Column(name = "MnufctTime")
    private Integer mnufctTime;
    @Column(name = "WholSlsTax")
    private Character wholSlsTax;
    @Column(name = "RetilrTax")
    private Character retilrTax;
    @Column(name = "SpcialDisc")
    private BigDecimal spcialDisc;
    @Column(name = "DscountCod")
    private Short dscountCod;
    @Column(name = "TrackSales")
    private Character trackSales;
    @Column(name = "SalUnitMsr")
    private String salUnitMsr;
    @Column(name = "NumInSale")
    private BigDecimal numInSale;
    @Column(name = "Consig")
    private BigDecimal consig;
    @Column(name = "QueryGroup")
    private Integer queryGroup;
    @Column(name = "Counted")
    private BigDecimal counted;
    @Column(name = "OpenBlnc")
    private BigDecimal openBlnc;
    @Column(name = "EvalSystem")
    private Character evalSystem;
    @Column(name = "UserSign")
    private Short userSign;
    @Column(name = "FREE")
    private Character free;
    @Column(name = "PicturName")
    private String picturName;
    @Column(name = "Transfered")
    private Character transfered;
    @Column(name = "BlncTrnsfr")
    private Character blncTrnsfr;
    @Lob
    @Column(name = "UserText")
    private String userText;
    @Column(name = "SerialNum")
    private String serialNum;
    @Column(name = "CommisPcnt")
    private BigDecimal commisPcnt;
    @Column(name = "CommisSum")
    private BigDecimal commisSum;
    @Column(name = "CommisGrp")
    private Short commisGrp;
    @Column(name = "TreeType")
    private Character treeType;
    @Column(name = "TreeQty")
    private BigDecimal treeQty;
    @Column(name = "LastPurPrc")
    private BigDecimal lastPurPrc;
    @Column(name = "LastPurCur")
    private String lastPurCur;
    @Column(name = "LastPurDat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastPurDat;
    @Column(name = "ExitCur")
    private String exitCur;
    @Column(name = "ExitPrice")
    private BigDecimal exitPrice;
    @Column(name = "ExitWH")
    private String exitWH;
    @Column(name = "AssetItem")
    private Character assetItem;
    @Column(name = "WasCounted")
    private Character wasCounted;
    @Column(name = "ManSerNum")
    private Character manSerNum;
    @Column(name = "SHeight1")
    private BigDecimal sHeight1;
    @Column(name = "SHght1Unit")
    private Short sHght1Unit;
    @Column(name = "SHeight2")
    private BigDecimal sHeight2;
    @Column(name = "SHght2Unit")
    private Short sHght2Unit;
    @Column(name = "SWidth1")
    private BigDecimal sWidth1;
    @Column(name = "SWdth1Unit")
    private Short sWdth1Unit;
    @Column(name = "SWidth2")
    private BigDecimal sWidth2;
    @Column(name = "SWdth2Unit")
    private Short sWdth2Unit;
    @Column(name = "SLength1")
    private BigDecimal sLength1;
    @Column(name = "SLen1Unit")
    private Short sLen1Unit;
    @Column(name = "Slength2")
    private BigDecimal slength2;
    @Column(name = "SLen2Unit")
    private Short sLen2Unit;
    @Column(name = "SVolume")
    private BigDecimal sVolume;
    @Column(name = "SVolUnit")
    private Short sVolUnit;
    @Column(name = "SWeight1")
    private BigDecimal sWeight1;
    @Column(name = "SWght1Unit")
    private Short sWght1Unit;
    @Column(name = "SWeight2")
    private BigDecimal sWeight2;
    @Column(name = "SWght2Unit")
    private Short sWght2Unit;
    @Column(name = "BHeight1")
    private BigDecimal bHeight1;
    @Column(name = "BHght1Unit")
    private Short bHght1Unit;
    @Column(name = "BHeight2")
    private BigDecimal bHeight2;
    @Column(name = "BHght2Unit")
    private Short bHght2Unit;
    @Column(name = "BWidth1")
    private BigDecimal bWidth1;
    @Column(name = "BWdth1Unit")
    private Short bWdth1Unit;
    @Column(name = "BWidth2")
    private BigDecimal bWidth2;
    @Column(name = "BWdth2Unit")
    private Short bWdth2Unit;
    @Column(name = "BLength1")
    private BigDecimal bLength1;
    @Column(name = "BLen1Unit")
    private Short bLen1Unit;
    @Column(name = "Blength2")
    private BigDecimal blength2;
    @Column(name = "BLen2Unit")
    private Short bLen2Unit;
    @Column(name = "BVolume")
    private BigDecimal bVolume;
    @Column(name = "BVolUnit")
    private Short bVolUnit;
    @Column(name = "BWeight1")
    private BigDecimal bWeight1;
    @Column(name = "BWght1Unit")
    private Short bWght1Unit;
    @Column(name = "BWeight2")
    private BigDecimal bWeight2;
    @Column(name = "BWght2Unit")
    private Short bWght2Unit;
    @Column(name = "FixCurrCms")
    private String fixCurrCms;
    @Column(name = "FirmCode")
    private Short firmCode;
    @Column(name = "LstSalDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lstSalDate;
    @Column(name = "QryGroup1")
    private Character qryGroup1;
    @Column(name = "QryGroup2")
    private Character qryGroup2;
    @Column(name = "QryGroup3")
    private Character qryGroup3;
    @Column(name = "QryGroup4")
    private Character qryGroup4;
    @Column(name = "QryGroup5")
    private Character qryGroup5;
    @Column(name = "QryGroup6")
    private Character qryGroup6;
    @Column(name = "QryGroup7")
    private Character qryGroup7;
    @Column(name = "QryGroup8")
    private Character qryGroup8;
    @Column(name = "QryGroup9")
    private Character qryGroup9;
    @Column(name = "QryGroup10")
    private Character qryGroup10;
    @Column(name = "QryGroup11")
    private Character qryGroup11;
    @Column(name = "QryGroup12")
    private Character qryGroup12;
    @Column(name = "QryGroup13")
    private Character qryGroup13;
    @Column(name = "QryGroup14")
    private Character qryGroup14;
    @Column(name = "QryGroup15")
    private Character qryGroup15;
    @Column(name = "QryGroup16")
    private Character qryGroup16;
    @Column(name = "QryGroup17")
    private Character qryGroup17;
    @Column(name = "QryGroup18")
    private Character qryGroup18;
    @Column(name = "QryGroup19")
    private Character qryGroup19;
    @Column(name = "QryGroup20")
    private Character qryGroup20;
    @Column(name = "QryGroup21")
    private Character qryGroup21;
    @Column(name = "QryGroup22")
    private Character qryGroup22;
    @Column(name = "QryGroup23")
    private Character qryGroup23;
    @Column(name = "QryGroup24")
    private Character qryGroup24;
    @Column(name = "QryGroup25")
    private Character qryGroup25;
    @Column(name = "QryGroup26")
    private Character qryGroup26;
    @Column(name = "QryGroup27")
    private Character qryGroup27;
    @Column(name = "QryGroup28")
    private Character qryGroup28;
    @Column(name = "QryGroup29")
    private Character qryGroup29;
    @Column(name = "QryGroup30")
    private Character qryGroup30;
    @Column(name = "QryGroup31")
    private Character qryGroup31;
    @Column(name = "QryGroup32")
    private Character qryGroup32;
    @Column(name = "QryGroup33")
    private Character qryGroup33;
    @Column(name = "QryGroup34")
    private Character qryGroup34;
    @Column(name = "QryGroup35")
    private Character qryGroup35;
    @Column(name = "QryGroup36")
    private Character qryGroup36;
    @Column(name = "QryGroup37")
    private Character qryGroup37;
    @Column(name = "QryGroup38")
    private Character qryGroup38;
    @Column(name = "QryGroup39")
    private Character qryGroup39;
    @Column(name = "QryGroup40")
    private Character qryGroup40;
    @Column(name = "QryGroup41")
    private Character qryGroup41;
    @Column(name = "QryGroup42")
    private Character qryGroup42;
    @Column(name = "QryGroup43")
    private Character qryGroup43;
    @Column(name = "QryGroup44")
    private Character qryGroup44;
    @Column(name = "QryGroup45")
    private Character qryGroup45;
    @Column(name = "QryGroup46")
    private Character qryGroup46;
    @Column(name = "QryGroup47")
    private Character qryGroup47;
    @Column(name = "QryGroup48")
    private Character qryGroup48;
    @Column(name = "QryGroup49")
    private Character qryGroup49;
    @Column(name = "QryGroup50")
    private Character qryGroup50;
    @Column(name = "QryGroup51")
    private Character qryGroup51;
    @Column(name = "QryGroup52")
    private Character qryGroup52;
    @Column(name = "QryGroup53")
    private Character qryGroup53;
    @Column(name = "QryGroup54")
    private Character qryGroup54;
    @Column(name = "QryGroup55")
    private Character qryGroup55;
    @Column(name = "QryGroup56")
    private Character qryGroup56;
    @Column(name = "QryGroup57")
    private Character qryGroup57;
    @Column(name = "QryGroup58")
    private Character qryGroup58;
    @Column(name = "QryGroup59")
    private Character qryGroup59;
    @Column(name = "QryGroup60")
    private Character qryGroup60;
    @Column(name = "QryGroup61")
    private Character qryGroup61;
    @Column(name = "QryGroup62")
    private Character qryGroup62;
    @Column(name = "QryGroup63")
    private Character qryGroup63;
    @Column(name = "QryGroup64")
    private Character qryGroup64;
    @Column(name = "CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "UpdateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @Column(name = "ExportCode")
    private String exportCode;
    @Column(name = "SalFactor1")
    private BigDecimal salFactor1;
    @Column(name = "SalFactor2")
    private BigDecimal salFactor2;
    @Column(name = "SalFactor3")
    private BigDecimal salFactor3;
    @Column(name = "SalFactor4")
    private BigDecimal salFactor4;
    @Column(name = "PurFactor1")
    private BigDecimal purFactor1;
    @Column(name = "PurFactor2")
    private BigDecimal purFactor2;
    @Column(name = "PurFactor3")
    private BigDecimal purFactor3;
    @Column(name = "PurFactor4")
    private BigDecimal purFactor4;
    @Column(name = "SalFormula")
    private String salFormula;
    @Column(name = "PurFormula")
    private String purFormula;
    @Column(name = "VatGroupPu")
    private String vatGroupPu;
    @Column(name = "AvgPrice")
    private BigDecimal avgPrice;
    @Column(name = "PurPackMsr")
    private String purPackMsr;
    @Column(name = "PurPackUn")
    private BigDecimal purPackUn;
    @Column(name = "SalPackMsr")
    private String salPackMsr;
    @Column(name = "SalPackUn")
    private BigDecimal salPackUn;
    @Column(name = "SCNCounter")
    private Short sCNCounter;
    @Column(name = "ManBtchNum")
    private Character manBtchNum;
    @Column(name = "ManOutOnly")
    private Character manOutOnly;
    @Column(name = "DataSource")
    private Character dataSource;
    @Column(name = "validFor")
    private Character validFor;
    @Column(name = "validFrom")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validFrom;
    @Column(name = "validTo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validTo;
    @Column(name = "frozenFor")
    private Character frozenFor;
    @Column(name = "frozenFrom")
    @Temporal(TemporalType.TIMESTAMP)
    private Date frozenFrom;
    @Column(name = "frozenTo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date frozenTo;
    @Column(name = "BlockOut")
    private Character blockOut;
    @Column(name = "ValidComm")
    private String validComm;
    @Column(name = "FrozenComm")
    private String frozenComm;
    @Column(name = "LogInstanc")
    private Integer logInstanc;
    @Column(name = "ObjType")
    private String objType;
    @Column(name = "SWW")
    private String sww;
    @Column(name = "Deleted")
    private Character deleted;
    @Column(name = "DocEntry")
    private Integer docEntry;
    @Column(name = "ExpensAcct")
    private String expensAcct;
    @Column(name = "FrgnInAcct")
    private String frgnInAcct;
    @Column(name = "ShipType")
    private Short shipType;
    @Column(name = "GLMethod")
    private Character gLMethod;
    @Column(name = "ECInAcct")
    private String eCInAcct;
    @Column(name = "FrgnExpAcc")
    private String frgnExpAcc;
    @Column(name = "ECExpAcc")
    private String eCExpAcc;
    @Column(name = "TaxType")
    private Character taxType;
    @Column(name = "ByWh")
    private Character byWh;
    @Column(name = "WTLiable")
    private Character wTLiable;
    @Column(name = "ItemType")
    private Character itemType;
    @Column(name = "WarrntTmpl")
    private String warrntTmpl;
    @Column(name = "BaseUnit")
    private String baseUnit;
    @Column(name = "CountryOrg")
    private String countryOrg;
    @Column(name = "StockValue")
    private BigDecimal stockValue;
    @Column(name = "Phantom")
    private Character phantom;
    @Column(name = "IssueMthd")
    private Character issueMthd;
    @Column(name = "FREE1")
    private Character free1;
    @Column(name = "PricingPrc")
    private BigDecimal pricingPrc;
    @Column(name = "MngMethod")
    private Character mngMethod;
    @Column(name = "ReorderPnt")
    private BigDecimal reorderPnt;
    @Column(name = "InvntryUom")
    private String invntryUom;
    @Column(name = "PlaningSys")
    private Character planingSys;
    @Column(name = "PrcrmntMtd")
    private Character prcrmntMtd;
    @Column(name = "OrdrIntrvl")
    private Short ordrIntrvl;
    @Column(name = "OrdrMulti")
    private BigDecimal ordrMulti;
    @Column(name = "MinOrdrQty")
    private BigDecimal minOrdrQty;
    @Column(name = "LeadTime")
    private Integer leadTime;
    @Column(name = "IndirctTax")
    private Character indirctTax;
    @Column(name = "TaxCodeAR")
    private String taxCodeAR;
    @Column(name = "TaxCodeAP")
    private String taxCodeAP;
    @Column(name = "OSvcCode")
    private Integer oSvcCode;
    @Column(name = "ISvcCode")
    private Integer iSvcCode;
    @Column(name = "ServiceGrp")
    private Integer serviceGrp;
    @Column(name = "NCMCode")
    private Integer nCMCode;
    @Column(name = "MatType")
    private String matType;
    @Column(name = "MatGrp")
    private Integer matGrp;
    @Column(name = "ProductSrc")
    private String productSrc;
    @Column(name = "ServiceCtg")
    private Integer serviceCtg;
    @Column(name = "ItemClass")
    private Character itemClass;
    @Column(name = "Excisable")
    private Character excisable;
    @Column(name = "ChapterID")
    private Integer chapterID;
    @Column(name = "NotifyASN")
    private String notifyASN;
    @Column(name = "ProAssNum")
    private String proAssNum;
    @Column(name = "AssblValue")
    private BigDecimal assblValue;
    @Column(name = "DNFEntry")
    private Integer dNFEntry;
    @Column(name = "UserSign2")
    private Short userSign2;
    @Column(name = "Spec")
    private String spec;
    @Column(name = "TaxCtg")
    private String taxCtg;
    @Column(name = "Series")
    private Short series;
    @Column(name = "Number")
    private Integer number;
    @Column(name = "FuelCode")
    private Integer fuelCode;
    @Column(name = "BeverTblC")
    private String beverTblC;
    @Column(name = "BeverGrpC")
    private String beverGrpC;
    @Column(name = "BeverTM")
    private Integer beverTM;
    @Lob
    @Column(name = "Attachment")
    private String attachment;
    @Column(name = "AtcEntry")
    private Integer atcEntry;
    @Column(name = "ToleranDay")
    private Integer toleranDay;
    @Column(name = "UgpEntry")
    private Integer ugpEntry;
    @Column(name = "PUoMEntry")
    private Integer pUoMEntry;
    @Column(name = "SUoMEntry")
    private Integer sUoMEntry;
    @Column(name = "IUoMEntry")
    private Integer iUoMEntry;
    @Column(name = "IssuePriBy")
    private Short issuePriBy;
    @Column(name = "AssetClass")
    private String assetClass;
    @Column(name = "AssetGroup")
    private String assetGroup;
    @Column(name = "InventryNo")
    private String inventryNo;
    @Column(name = "Technician")
    private Integer technician;
    @Column(name = "Employee")
    private Integer employee;
    @Column(name = "Location")
    private Integer location;
    @Column(name = "StatAsset")
    private Character statAsset;
    @Column(name = "Cession")
    private Character cession;
    @Column(name = "DeacAftUL")
    private Character deacAftUL;
    @Column(name = "AsstStatus")
    private Character asstStatus;
    @Column(name = "CapDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date capDate;
    @Column(name = "AcqDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date acqDate;
    @Column(name = "RetDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date retDate;
    @Column(name = "GLPickMeth")
    private Character gLPickMeth;
    @Column(name = "NoDiscount")
    private Character noDiscount;
    @Column(name = "MgrByQty")
    private Character mgrByQty;
    @Column(name = "AssetRmk1")
    private String assetRmk1;
    @Column(name = "AssetRmk2")
    private String assetRmk2;
    @Column(name = "AssetAmnt1")
    private BigDecimal assetAmnt1;
    @Column(name = "AssetAmnt2")
    private BigDecimal assetAmnt2;
    @Column(name = "DeprGroup")
    private String deprGroup;
    @Column(name = "AssetSerNo")
    private String assetSerNo;
    @Column(name = "CntUnitMsr")
    private String cntUnitMsr;
    @Column(name = "NumInCnt")
    private BigDecimal numInCnt;
    @Column(name = "INUoMEntry")
    private Integer iNUoMEntry;
    @Column(name = "OneBOneRec")
    private Character oneBOneRec;
    @Column(name = "RuleCode")
    private String ruleCode;
    @Column(name = "ScsCode")
    private String scsCode;
    @Column(name = "SpProdType")
    private String spProdType;
    @Column(name = "IWeight1")
    private BigDecimal iWeight1;
    @Column(name = "IWght1Unit")
    private Short iWght1Unit;
    @Column(name = "IWeight2")
    private BigDecimal iWeight2;
    @Column(name = "IWght2Unit")
    private Short iWght2Unit;
    @Column(name = "CompoWH")
    private Character compoWH;
    @Column(name = "CreateTS")
    private Integer createTS;
    @Column(name = "UpdateTS")
    private Integer updateTS;
    @Column(name = "VirtAstItm")
    private Character virtAstItm;
    @Column(name = "SouVirAsst")
    private String souVirAsst;
    @Column(name = "InCostRoll")
    private Character inCostRoll;
    @Column(name = "PrdStdCst")
    private BigDecimal prdStdCst;
    @Column(name = "EnAstSeri")
    private Character enAstSeri;
    @Column(name = "LinkRsc")
    private String linkRsc;
    @Column(name = "OnHldPert")
    private BigDecimal onHldPert;
    @Column(name = "onHldLimt")
    private BigDecimal onHldLimt;
    @Column(name = "GSTRelevnt")
    private Character gSTRelevnt;
    @Column(name = "SACEntry")
    private Integer sACEntry;
    @Column(name = "GstTaxCtg")
    private Character gstTaxCtg;
    @Column(name = "U_IGroup")
    private String uIGroup;
    @Column(name = "U_SUBGR")
    private String uSubgr;
    @Column(name = "U_RDCODE")
    private String uRdcode;
    @Column(name = "U_IGroupName")
    private String uIGroupName;
    @Column(name = "U_SUBGRName")
    private String uSUBGRName;
    @Column(name = "U_ProductBranch")
    private String uProductBranch;
    @Column(name = "U_ProductGroup")
    private String uProductGroup;
    @Column(name = "U_Forcast")
    private String uForcast;
    @Column(name = "U_ShortName")
    private String uShortName;
    @Lob
    @Column(name = "U_TechName")
    private String uTechName;
    @Column(name = "U_DGroup")
    private String uDGroup;
    @Column(name = "U_DGroupName")
    private String uDGroupName;
    @Column(name = "U_Package")
    private BigDecimal uPackage;
    @Lob
    @Column(name = "U_MSL")
    private String uMsl;
    @Column(name = "U_PartNumber")
    private String uPartNumber;

    public Oitm() {
    }

    public Oitm(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getFrgnName() {
        return frgnName;
    }

    public void setFrgnName(String frgnName) {
        this.frgnName = frgnName;
    }

    public Short getItmsGrpCod() {
        return itmsGrpCod;
    }

    public void setItmsGrpCod(Short itmsGrpCod) {
        this.itmsGrpCod = itmsGrpCod;
    }

    public Short getCstGrpCode() {
        return cstGrpCode;
    }

    public void setCstGrpCode(Short cstGrpCode) {
        this.cstGrpCode = cstGrpCode;
    }

    public String getVatGourpSa() {
        return vatGourpSa;
    }

    public void setVatGourpSa(String vatGourpSa) {
        this.vatGourpSa = vatGourpSa;
    }

    public String getCodeBars() {
        return codeBars;
    }

    public void setCodeBars(String codeBars) {
        this.codeBars = codeBars;
    }

    public Character getVATLiable() {
        return vATLiable;
    }

    public void setVATLiable(Character vATLiable) {
        this.vATLiable = vATLiable;
    }

    public Character getPrchseItem() {
        return prchseItem;
    }

    public void setPrchseItem(Character prchseItem) {
        this.prchseItem = prchseItem;
    }

    public Character getSellItem() {
        return sellItem;
    }

    public void setSellItem(Character sellItem) {
        this.sellItem = sellItem;
    }

    public Character getInvntItem() {
        return invntItem;
    }

    public void setInvntItem(Character invntItem) {
        this.invntItem = invntItem;
    }

    public BigDecimal getOnHand() {
        return onHand;
    }

    public void setOnHand(BigDecimal onHand) {
        this.onHand = onHand;
    }

    public BigDecimal getIsCommited() {
        return isCommited;
    }

    public void setIsCommited(BigDecimal isCommited) {
        this.isCommited = isCommited;
    }

    public BigDecimal getOnOrder() {
        return onOrder;
    }

    public void setOnOrder(BigDecimal onOrder) {
        this.onOrder = onOrder;
    }

    public String getIncomeAcct() {
        return incomeAcct;
    }

    public void setIncomeAcct(String incomeAcct) {
        this.incomeAcct = incomeAcct;
    }

    public String getExmptIncom() {
        return exmptIncom;
    }

    public void setExmptIncom(String exmptIncom) {
        this.exmptIncom = exmptIncom;
    }

    public BigDecimal getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(BigDecimal maxLevel) {
        this.maxLevel = maxLevel;
    }

    public String getDfltWH() {
        return dfltWH;
    }

    public void setDfltWH(String dfltWH) {
        this.dfltWH = dfltWH;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getSuppCatNum() {
        return suppCatNum;
    }

    public void setSuppCatNum(String suppCatNum) {
        this.suppCatNum = suppCatNum;
    }

    public String getBuyUnitMsr() {
        return buyUnitMsr;
    }

    public void setBuyUnitMsr(String buyUnitMsr) {
        this.buyUnitMsr = buyUnitMsr;
    }

    public BigDecimal getNumInBuy() {
        return numInBuy;
    }

    public void setNumInBuy(BigDecimal numInBuy) {
        this.numInBuy = numInBuy;
    }

    public BigDecimal getReorderQty() {
        return reorderQty;
    }

    public void setReorderQty(BigDecimal reorderQty) {
        this.reorderQty = reorderQty;
    }

    public BigDecimal getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(BigDecimal minLevel) {
        this.minLevel = minLevel;
    }

    public BigDecimal getLstEvlPric() {
        return lstEvlPric;
    }

    public void setLstEvlPric(BigDecimal lstEvlPric) {
        this.lstEvlPric = lstEvlPric;
    }

    public Date getLstEvlDate() {
        return lstEvlDate;
    }

    public void setLstEvlDate(Date lstEvlDate) {
        this.lstEvlDate = lstEvlDate;
    }

    public BigDecimal getCustomPer() {
        return customPer;
    }

    public void setCustomPer(BigDecimal customPer) {
        this.customPer = customPer;
    }

    public Character getCanceled() {
        return canceled;
    }

    public void setCanceled(Character canceled) {
        this.canceled = canceled;
    }

    public Integer getMnufctTime() {
        return mnufctTime;
    }

    public void setMnufctTime(Integer mnufctTime) {
        this.mnufctTime = mnufctTime;
    }

    public Character getWholSlsTax() {
        return wholSlsTax;
    }

    public void setWholSlsTax(Character wholSlsTax) {
        this.wholSlsTax = wholSlsTax;
    }

    public Character getRetilrTax() {
        return retilrTax;
    }

    public void setRetilrTax(Character retilrTax) {
        this.retilrTax = retilrTax;
    }

    public BigDecimal getSpcialDisc() {
        return spcialDisc;
    }

    public void setSpcialDisc(BigDecimal spcialDisc) {
        this.spcialDisc = spcialDisc;
    }

    public Short getDscountCod() {
        return dscountCod;
    }

    public void setDscountCod(Short dscountCod) {
        this.dscountCod = dscountCod;
    }

    public Character getTrackSales() {
        return trackSales;
    }

    public void setTrackSales(Character trackSales) {
        this.trackSales = trackSales;
    }

    public String getSalUnitMsr() {
        return salUnitMsr;
    }

    public void setSalUnitMsr(String salUnitMsr) {
        this.salUnitMsr = salUnitMsr;
    }

    public BigDecimal getNumInSale() {
        return numInSale;
    }

    public void setNumInSale(BigDecimal numInSale) {
        this.numInSale = numInSale;
    }

    public BigDecimal getConsig() {
        return consig;
    }

    public void setConsig(BigDecimal consig) {
        this.consig = consig;
    }

    public Integer getQueryGroup() {
        return queryGroup;
    }

    public void setQueryGroup(Integer queryGroup) {
        this.queryGroup = queryGroup;
    }

    public BigDecimal getCounted() {
        return counted;
    }

    public void setCounted(BigDecimal counted) {
        this.counted = counted;
    }

    public BigDecimal getOpenBlnc() {
        return openBlnc;
    }

    public void setOpenBlnc(BigDecimal openBlnc) {
        this.openBlnc = openBlnc;
    }

    public Character getEvalSystem() {
        return evalSystem;
    }

    public void setEvalSystem(Character evalSystem) {
        this.evalSystem = evalSystem;
    }

    public Short getUserSign() {
        return userSign;
    }

    public void setUserSign(Short userSign) {
        this.userSign = userSign;
    }

    public Character getFree() {
        return free;
    }

    public void setFree(Character free) {
        this.free = free;
    }

    public String getPicturName() {
        return picturName;
    }

    public void setPicturName(String picturName) {
        this.picturName = picturName;
    }

    public Character getTransfered() {
        return transfered;
    }

    public void setTransfered(Character transfered) {
        this.transfered = transfered;
    }

    public Character getBlncTrnsfr() {
        return blncTrnsfr;
    }

    public void setBlncTrnsfr(Character blncTrnsfr) {
        this.blncTrnsfr = blncTrnsfr;
    }

    public String getUserText() {
        return userText;
    }

    public void setUserText(String userText) {
        this.userText = userText;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public BigDecimal getCommisPcnt() {
        return commisPcnt;
    }

    public void setCommisPcnt(BigDecimal commisPcnt) {
        this.commisPcnt = commisPcnt;
    }

    public BigDecimal getCommisSum() {
        return commisSum;
    }

    public void setCommisSum(BigDecimal commisSum) {
        this.commisSum = commisSum;
    }

    public Short getCommisGrp() {
        return commisGrp;
    }

    public void setCommisGrp(Short commisGrp) {
        this.commisGrp = commisGrp;
    }

    public Character getTreeType() {
        return treeType;
    }

    public void setTreeType(Character treeType) {
        this.treeType = treeType;
    }

    public BigDecimal getTreeQty() {
        return treeQty;
    }

    public void setTreeQty(BigDecimal treeQty) {
        this.treeQty = treeQty;
    }

    public BigDecimal getLastPurPrc() {
        return lastPurPrc;
    }

    public void setLastPurPrc(BigDecimal lastPurPrc) {
        this.lastPurPrc = lastPurPrc;
    }

    public String getLastPurCur() {
        return lastPurCur;
    }

    public void setLastPurCur(String lastPurCur) {
        this.lastPurCur = lastPurCur;
    }

    public Date getLastPurDat() {
        return lastPurDat;
    }

    public void setLastPurDat(Date lastPurDat) {
        this.lastPurDat = lastPurDat;
    }

    public String getExitCur() {
        return exitCur;
    }

    public void setExitCur(String exitCur) {
        this.exitCur = exitCur;
    }

    public BigDecimal getExitPrice() {
        return exitPrice;
    }

    public void setExitPrice(BigDecimal exitPrice) {
        this.exitPrice = exitPrice;
    }

    public String getExitWH() {
        return exitWH;
    }

    public void setExitWH(String exitWH) {
        this.exitWH = exitWH;
    }

    public Character getAssetItem() {
        return assetItem;
    }

    public void setAssetItem(Character assetItem) {
        this.assetItem = assetItem;
    }

    public Character getWasCounted() {
        return wasCounted;
    }

    public void setWasCounted(Character wasCounted) {
        this.wasCounted = wasCounted;
    }

    public Character getManSerNum() {
        return manSerNum;
    }

    public void setManSerNum(Character manSerNum) {
        this.manSerNum = manSerNum;
    }

    public BigDecimal getSHeight1() {
        return sHeight1;
    }

    public void setSHeight1(BigDecimal sHeight1) {
        this.sHeight1 = sHeight1;
    }

    public Short getSHght1Unit() {
        return sHght1Unit;
    }

    public void setSHght1Unit(Short sHght1Unit) {
        this.sHght1Unit = sHght1Unit;
    }

    public BigDecimal getSHeight2() {
        return sHeight2;
    }

    public void setSHeight2(BigDecimal sHeight2) {
        this.sHeight2 = sHeight2;
    }

    public Short getSHght2Unit() {
        return sHght2Unit;
    }

    public void setSHght2Unit(Short sHght2Unit) {
        this.sHght2Unit = sHght2Unit;
    }

    public BigDecimal getSWidth1() {
        return sWidth1;
    }

    public void setSWidth1(BigDecimal sWidth1) {
        this.sWidth1 = sWidth1;
    }

    public Short getSWdth1Unit() {
        return sWdth1Unit;
    }

    public void setSWdth1Unit(Short sWdth1Unit) {
        this.sWdth1Unit = sWdth1Unit;
    }

    public BigDecimal getSWidth2() {
        return sWidth2;
    }

    public void setSWidth2(BigDecimal sWidth2) {
        this.sWidth2 = sWidth2;
    }

    public Short getSWdth2Unit() {
        return sWdth2Unit;
    }

    public void setSWdth2Unit(Short sWdth2Unit) {
        this.sWdth2Unit = sWdth2Unit;
    }

    public BigDecimal getSLength1() {
        return sLength1;
    }

    public void setSLength1(BigDecimal sLength1) {
        this.sLength1 = sLength1;
    }

    public Short getSLen1Unit() {
        return sLen1Unit;
    }

    public void setSLen1Unit(Short sLen1Unit) {
        this.sLen1Unit = sLen1Unit;
    }

    public BigDecimal getSlength2() {
        return slength2;
    }

    public void setSlength2(BigDecimal slength2) {
        this.slength2 = slength2;
    }

    public Short getSLen2Unit() {
        return sLen2Unit;
    }

    public void setSLen2Unit(Short sLen2Unit) {
        this.sLen2Unit = sLen2Unit;
    }

    public BigDecimal getSVolume() {
        return sVolume;
    }

    public void setSVolume(BigDecimal sVolume) {
        this.sVolume = sVolume;
    }

    public Short getSVolUnit() {
        return sVolUnit;
    }

    public void setSVolUnit(Short sVolUnit) {
        this.sVolUnit = sVolUnit;
    }

    public BigDecimal getSWeight1() {
        return sWeight1;
    }

    public void setSWeight1(BigDecimal sWeight1) {
        this.sWeight1 = sWeight1;
    }

    public Short getSWght1Unit() {
        return sWght1Unit;
    }

    public void setSWght1Unit(Short sWght1Unit) {
        this.sWght1Unit = sWght1Unit;
    }

    public BigDecimal getSWeight2() {
        return sWeight2;
    }

    public void setSWeight2(BigDecimal sWeight2) {
        this.sWeight2 = sWeight2;
    }

    public Short getSWght2Unit() {
        return sWght2Unit;
    }

    public void setSWght2Unit(Short sWght2Unit) {
        this.sWght2Unit = sWght2Unit;
    }

    public BigDecimal getBHeight1() {
        return bHeight1;
    }

    public void setBHeight1(BigDecimal bHeight1) {
        this.bHeight1 = bHeight1;
    }

    public Short getBHght1Unit() {
        return bHght1Unit;
    }

    public void setBHght1Unit(Short bHght1Unit) {
        this.bHght1Unit = bHght1Unit;
    }

    public BigDecimal getBHeight2() {
        return bHeight2;
    }

    public void setBHeight2(BigDecimal bHeight2) {
        this.bHeight2 = bHeight2;
    }

    public Short getBHght2Unit() {
        return bHght2Unit;
    }

    public void setBHght2Unit(Short bHght2Unit) {
        this.bHght2Unit = bHght2Unit;
    }

    public BigDecimal getBWidth1() {
        return bWidth1;
    }

    public void setBWidth1(BigDecimal bWidth1) {
        this.bWidth1 = bWidth1;
    }

    public Short getBWdth1Unit() {
        return bWdth1Unit;
    }

    public void setBWdth1Unit(Short bWdth1Unit) {
        this.bWdth1Unit = bWdth1Unit;
    }

    public BigDecimal getBWidth2() {
        return bWidth2;
    }

    public void setBWidth2(BigDecimal bWidth2) {
        this.bWidth2 = bWidth2;
    }

    public Short getBWdth2Unit() {
        return bWdth2Unit;
    }

    public void setBWdth2Unit(Short bWdth2Unit) {
        this.bWdth2Unit = bWdth2Unit;
    }

    public BigDecimal getBLength1() {
        return bLength1;
    }

    public void setBLength1(BigDecimal bLength1) {
        this.bLength1 = bLength1;
    }

    public Short getBLen1Unit() {
        return bLen1Unit;
    }

    public void setBLen1Unit(Short bLen1Unit) {
        this.bLen1Unit = bLen1Unit;
    }

    public BigDecimal getBlength2() {
        return blength2;
    }

    public void setBlength2(BigDecimal blength2) {
        this.blength2 = blength2;
    }

    public Short getBLen2Unit() {
        return bLen2Unit;
    }

    public void setBLen2Unit(Short bLen2Unit) {
        this.bLen2Unit = bLen2Unit;
    }

    public BigDecimal getBVolume() {
        return bVolume;
    }

    public void setBVolume(BigDecimal bVolume) {
        this.bVolume = bVolume;
    }

    public Short getBVolUnit() {
        return bVolUnit;
    }

    public void setBVolUnit(Short bVolUnit) {
        this.bVolUnit = bVolUnit;
    }

    public BigDecimal getBWeight1() {
        return bWeight1;
    }

    public void setBWeight1(BigDecimal bWeight1) {
        this.bWeight1 = bWeight1;
    }

    public Short getBWght1Unit() {
        return bWght1Unit;
    }

    public void setBWght1Unit(Short bWght1Unit) {
        this.bWght1Unit = bWght1Unit;
    }

    public BigDecimal getBWeight2() {
        return bWeight2;
    }

    public void setBWeight2(BigDecimal bWeight2) {
        this.bWeight2 = bWeight2;
    }

    public Short getBWght2Unit() {
        return bWght2Unit;
    }

    public void setBWght2Unit(Short bWght2Unit) {
        this.bWght2Unit = bWght2Unit;
    }

    public String getFixCurrCms() {
        return fixCurrCms;
    }

    public void setFixCurrCms(String fixCurrCms) {
        this.fixCurrCms = fixCurrCms;
    }

    public Short getFirmCode() {
        return firmCode;
    }

    public void setFirmCode(Short firmCode) {
        this.firmCode = firmCode;
    }

    public Date getLstSalDate() {
        return lstSalDate;
    }

    public void setLstSalDate(Date lstSalDate) {
        this.lstSalDate = lstSalDate;
    }

    public Character getQryGroup1() {
        return qryGroup1;
    }

    public void setQryGroup1(Character qryGroup1) {
        this.qryGroup1 = qryGroup1;
    }

    public Character getQryGroup2() {
        return qryGroup2;
    }

    public void setQryGroup2(Character qryGroup2) {
        this.qryGroup2 = qryGroup2;
    }

    public Character getQryGroup3() {
        return qryGroup3;
    }

    public void setQryGroup3(Character qryGroup3) {
        this.qryGroup3 = qryGroup3;
    }

    public Character getQryGroup4() {
        return qryGroup4;
    }

    public void setQryGroup4(Character qryGroup4) {
        this.qryGroup4 = qryGroup4;
    }

    public Character getQryGroup5() {
        return qryGroup5;
    }

    public void setQryGroup5(Character qryGroup5) {
        this.qryGroup5 = qryGroup5;
    }

    public Character getQryGroup6() {
        return qryGroup6;
    }

    public void setQryGroup6(Character qryGroup6) {
        this.qryGroup6 = qryGroup6;
    }

    public Character getQryGroup7() {
        return qryGroup7;
    }

    public void setQryGroup7(Character qryGroup7) {
        this.qryGroup7 = qryGroup7;
    }

    public Character getQryGroup8() {
        return qryGroup8;
    }

    public void setQryGroup8(Character qryGroup8) {
        this.qryGroup8 = qryGroup8;
    }

    public Character getQryGroup9() {
        return qryGroup9;
    }

    public void setQryGroup9(Character qryGroup9) {
        this.qryGroup9 = qryGroup9;
    }

    public Character getQryGroup10() {
        return qryGroup10;
    }

    public void setQryGroup10(Character qryGroup10) {
        this.qryGroup10 = qryGroup10;
    }

    public Character getQryGroup11() {
        return qryGroup11;
    }

    public void setQryGroup11(Character qryGroup11) {
        this.qryGroup11 = qryGroup11;
    }

    public Character getQryGroup12() {
        return qryGroup12;
    }

    public void setQryGroup12(Character qryGroup12) {
        this.qryGroup12 = qryGroup12;
    }

    public Character getQryGroup13() {
        return qryGroup13;
    }

    public void setQryGroup13(Character qryGroup13) {
        this.qryGroup13 = qryGroup13;
    }

    public Character getQryGroup14() {
        return qryGroup14;
    }

    public void setQryGroup14(Character qryGroup14) {
        this.qryGroup14 = qryGroup14;
    }

    public Character getQryGroup15() {
        return qryGroup15;
    }

    public void setQryGroup15(Character qryGroup15) {
        this.qryGroup15 = qryGroup15;
    }

    public Character getQryGroup16() {
        return qryGroup16;
    }

    public void setQryGroup16(Character qryGroup16) {
        this.qryGroup16 = qryGroup16;
    }

    public Character getQryGroup17() {
        return qryGroup17;
    }

    public void setQryGroup17(Character qryGroup17) {
        this.qryGroup17 = qryGroup17;
    }

    public Character getQryGroup18() {
        return qryGroup18;
    }

    public void setQryGroup18(Character qryGroup18) {
        this.qryGroup18 = qryGroup18;
    }

    public Character getQryGroup19() {
        return qryGroup19;
    }

    public void setQryGroup19(Character qryGroup19) {
        this.qryGroup19 = qryGroup19;
    }

    public Character getQryGroup20() {
        return qryGroup20;
    }

    public void setQryGroup20(Character qryGroup20) {
        this.qryGroup20 = qryGroup20;
    }

    public Character getQryGroup21() {
        return qryGroup21;
    }

    public void setQryGroup21(Character qryGroup21) {
        this.qryGroup21 = qryGroup21;
    }

    public Character getQryGroup22() {
        return qryGroup22;
    }

    public void setQryGroup22(Character qryGroup22) {
        this.qryGroup22 = qryGroup22;
    }

    public Character getQryGroup23() {
        return qryGroup23;
    }

    public void setQryGroup23(Character qryGroup23) {
        this.qryGroup23 = qryGroup23;
    }

    public Character getQryGroup24() {
        return qryGroup24;
    }

    public void setQryGroup24(Character qryGroup24) {
        this.qryGroup24 = qryGroup24;
    }

    public Character getQryGroup25() {
        return qryGroup25;
    }

    public void setQryGroup25(Character qryGroup25) {
        this.qryGroup25 = qryGroup25;
    }

    public Character getQryGroup26() {
        return qryGroup26;
    }

    public void setQryGroup26(Character qryGroup26) {
        this.qryGroup26 = qryGroup26;
    }

    public Character getQryGroup27() {
        return qryGroup27;
    }

    public void setQryGroup27(Character qryGroup27) {
        this.qryGroup27 = qryGroup27;
    }

    public Character getQryGroup28() {
        return qryGroup28;
    }

    public void setQryGroup28(Character qryGroup28) {
        this.qryGroup28 = qryGroup28;
    }

    public Character getQryGroup29() {
        return qryGroup29;
    }

    public void setQryGroup29(Character qryGroup29) {
        this.qryGroup29 = qryGroup29;
    }

    public Character getQryGroup30() {
        return qryGroup30;
    }

    public void setQryGroup30(Character qryGroup30) {
        this.qryGroup30 = qryGroup30;
    }

    public Character getQryGroup31() {
        return qryGroup31;
    }

    public void setQryGroup31(Character qryGroup31) {
        this.qryGroup31 = qryGroup31;
    }

    public Character getQryGroup32() {
        return qryGroup32;
    }

    public void setQryGroup32(Character qryGroup32) {
        this.qryGroup32 = qryGroup32;
    }

    public Character getQryGroup33() {
        return qryGroup33;
    }

    public void setQryGroup33(Character qryGroup33) {
        this.qryGroup33 = qryGroup33;
    }

    public Character getQryGroup34() {
        return qryGroup34;
    }

    public void setQryGroup34(Character qryGroup34) {
        this.qryGroup34 = qryGroup34;
    }

    public Character getQryGroup35() {
        return qryGroup35;
    }

    public void setQryGroup35(Character qryGroup35) {
        this.qryGroup35 = qryGroup35;
    }

    public Character getQryGroup36() {
        return qryGroup36;
    }

    public void setQryGroup36(Character qryGroup36) {
        this.qryGroup36 = qryGroup36;
    }

    public Character getQryGroup37() {
        return qryGroup37;
    }

    public void setQryGroup37(Character qryGroup37) {
        this.qryGroup37 = qryGroup37;
    }

    public Character getQryGroup38() {
        return qryGroup38;
    }

    public void setQryGroup38(Character qryGroup38) {
        this.qryGroup38 = qryGroup38;
    }

    public Character getQryGroup39() {
        return qryGroup39;
    }

    public void setQryGroup39(Character qryGroup39) {
        this.qryGroup39 = qryGroup39;
    }

    public Character getQryGroup40() {
        return qryGroup40;
    }

    public void setQryGroup40(Character qryGroup40) {
        this.qryGroup40 = qryGroup40;
    }

    public Character getQryGroup41() {
        return qryGroup41;
    }

    public void setQryGroup41(Character qryGroup41) {
        this.qryGroup41 = qryGroup41;
    }

    public Character getQryGroup42() {
        return qryGroup42;
    }

    public void setQryGroup42(Character qryGroup42) {
        this.qryGroup42 = qryGroup42;
    }

    public Character getQryGroup43() {
        return qryGroup43;
    }

    public void setQryGroup43(Character qryGroup43) {
        this.qryGroup43 = qryGroup43;
    }

    public Character getQryGroup44() {
        return qryGroup44;
    }

    public void setQryGroup44(Character qryGroup44) {
        this.qryGroup44 = qryGroup44;
    }

    public Character getQryGroup45() {
        return qryGroup45;
    }

    public void setQryGroup45(Character qryGroup45) {
        this.qryGroup45 = qryGroup45;
    }

    public Character getQryGroup46() {
        return qryGroup46;
    }

    public void setQryGroup46(Character qryGroup46) {
        this.qryGroup46 = qryGroup46;
    }

    public Character getQryGroup47() {
        return qryGroup47;
    }

    public void setQryGroup47(Character qryGroup47) {
        this.qryGroup47 = qryGroup47;
    }

    public Character getQryGroup48() {
        return qryGroup48;
    }

    public void setQryGroup48(Character qryGroup48) {
        this.qryGroup48 = qryGroup48;
    }

    public Character getQryGroup49() {
        return qryGroup49;
    }

    public void setQryGroup49(Character qryGroup49) {
        this.qryGroup49 = qryGroup49;
    }

    public Character getQryGroup50() {
        return qryGroup50;
    }

    public void setQryGroup50(Character qryGroup50) {
        this.qryGroup50 = qryGroup50;
    }

    public Character getQryGroup51() {
        return qryGroup51;
    }

    public void setQryGroup51(Character qryGroup51) {
        this.qryGroup51 = qryGroup51;
    }

    public Character getQryGroup52() {
        return qryGroup52;
    }

    public void setQryGroup52(Character qryGroup52) {
        this.qryGroup52 = qryGroup52;
    }

    public Character getQryGroup53() {
        return qryGroup53;
    }

    public void setQryGroup53(Character qryGroup53) {
        this.qryGroup53 = qryGroup53;
    }

    public Character getQryGroup54() {
        return qryGroup54;
    }

    public void setQryGroup54(Character qryGroup54) {
        this.qryGroup54 = qryGroup54;
    }

    public Character getQryGroup55() {
        return qryGroup55;
    }

    public void setQryGroup55(Character qryGroup55) {
        this.qryGroup55 = qryGroup55;
    }

    public Character getQryGroup56() {
        return qryGroup56;
    }

    public void setQryGroup56(Character qryGroup56) {
        this.qryGroup56 = qryGroup56;
    }

    public Character getQryGroup57() {
        return qryGroup57;
    }

    public void setQryGroup57(Character qryGroup57) {
        this.qryGroup57 = qryGroup57;
    }

    public Character getQryGroup58() {
        return qryGroup58;
    }

    public void setQryGroup58(Character qryGroup58) {
        this.qryGroup58 = qryGroup58;
    }

    public Character getQryGroup59() {
        return qryGroup59;
    }

    public void setQryGroup59(Character qryGroup59) {
        this.qryGroup59 = qryGroup59;
    }

    public Character getQryGroup60() {
        return qryGroup60;
    }

    public void setQryGroup60(Character qryGroup60) {
        this.qryGroup60 = qryGroup60;
    }

    public Character getQryGroup61() {
        return qryGroup61;
    }

    public void setQryGroup61(Character qryGroup61) {
        this.qryGroup61 = qryGroup61;
    }

    public Character getQryGroup62() {
        return qryGroup62;
    }

    public void setQryGroup62(Character qryGroup62) {
        this.qryGroup62 = qryGroup62;
    }

    public Character getQryGroup63() {
        return qryGroup63;
    }

    public void setQryGroup63(Character qryGroup63) {
        this.qryGroup63 = qryGroup63;
    }

    public Character getQryGroup64() {
        return qryGroup64;
    }

    public void setQryGroup64(Character qryGroup64) {
        this.qryGroup64 = qryGroup64;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getExportCode() {
        return exportCode;
    }

    public void setExportCode(String exportCode) {
        this.exportCode = exportCode;
    }

    public BigDecimal getSalFactor1() {
        return salFactor1;
    }

    public void setSalFactor1(BigDecimal salFactor1) {
        this.salFactor1 = salFactor1;
    }

    public BigDecimal getSalFactor2() {
        return salFactor2;
    }

    public void setSalFactor2(BigDecimal salFactor2) {
        this.salFactor2 = salFactor2;
    }

    public BigDecimal getSalFactor3() {
        return salFactor3;
    }

    public void setSalFactor3(BigDecimal salFactor3) {
        this.salFactor3 = salFactor3;
    }

    public BigDecimal getSalFactor4() {
        return salFactor4;
    }

    public void setSalFactor4(BigDecimal salFactor4) {
        this.salFactor4 = salFactor4;
    }

    public BigDecimal getPurFactor1() {
        return purFactor1;
    }

    public void setPurFactor1(BigDecimal purFactor1) {
        this.purFactor1 = purFactor1;
    }

    public BigDecimal getPurFactor2() {
        return purFactor2;
    }

    public void setPurFactor2(BigDecimal purFactor2) {
        this.purFactor2 = purFactor2;
    }

    public BigDecimal getPurFactor3() {
        return purFactor3;
    }

    public void setPurFactor3(BigDecimal purFactor3) {
        this.purFactor3 = purFactor3;
    }

    public BigDecimal getPurFactor4() {
        return purFactor4;
    }

    public void setPurFactor4(BigDecimal purFactor4) {
        this.purFactor4 = purFactor4;
    }

    public String getSalFormula() {
        return salFormula;
    }

    public void setSalFormula(String salFormula) {
        this.salFormula = salFormula;
    }

    public String getPurFormula() {
        return purFormula;
    }

    public void setPurFormula(String purFormula) {
        this.purFormula = purFormula;
    }

    public String getVatGroupPu() {
        return vatGroupPu;
    }

    public void setVatGroupPu(String vatGroupPu) {
        this.vatGroupPu = vatGroupPu;
    }

    public BigDecimal getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(BigDecimal avgPrice) {
        this.avgPrice = avgPrice;
    }

    public String getPurPackMsr() {
        return purPackMsr;
    }

    public void setPurPackMsr(String purPackMsr) {
        this.purPackMsr = purPackMsr;
    }

    public BigDecimal getPurPackUn() {
        return purPackUn;
    }

    public void setPurPackUn(BigDecimal purPackUn) {
        this.purPackUn = purPackUn;
    }

    public String getSalPackMsr() {
        return salPackMsr;
    }

    public void setSalPackMsr(String salPackMsr) {
        this.salPackMsr = salPackMsr;
    }

    public BigDecimal getSalPackUn() {
        return salPackUn;
    }

    public void setSalPackUn(BigDecimal salPackUn) {
        this.salPackUn = salPackUn;
    }

    public Short getSCNCounter() {
        return sCNCounter;
    }

    public void setSCNCounter(Short sCNCounter) {
        this.sCNCounter = sCNCounter;
    }

    public Character getManBtchNum() {
        return manBtchNum;
    }

    public void setManBtchNum(Character manBtchNum) {
        this.manBtchNum = manBtchNum;
    }

    public Character getManOutOnly() {
        return manOutOnly;
    }

    public void setManOutOnly(Character manOutOnly) {
        this.manOutOnly = manOutOnly;
    }

    public Character getDataSource() {
        return dataSource;
    }

    public void setDataSource(Character dataSource) {
        this.dataSource = dataSource;
    }

    public Character getValidFor() {
        return validFor;
    }

    public void setValidFor(Character validFor) {
        this.validFor = validFor;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public Character getFrozenFor() {
        return frozenFor;
    }

    public void setFrozenFor(Character frozenFor) {
        this.frozenFor = frozenFor;
    }

    public Date getFrozenFrom() {
        return frozenFrom;
    }

    public void setFrozenFrom(Date frozenFrom) {
        this.frozenFrom = frozenFrom;
    }

    public Date getFrozenTo() {
        return frozenTo;
    }

    public void setFrozenTo(Date frozenTo) {
        this.frozenTo = frozenTo;
    }

    public Character getBlockOut() {
        return blockOut;
    }

    public void setBlockOut(Character blockOut) {
        this.blockOut = blockOut;
    }

    public String getValidComm() {
        return validComm;
    }

    public void setValidComm(String validComm) {
        this.validComm = validComm;
    }

    public String getFrozenComm() {
        return frozenComm;
    }

    public void setFrozenComm(String frozenComm) {
        this.frozenComm = frozenComm;
    }

    public Integer getLogInstanc() {
        return logInstanc;
    }

    public void setLogInstanc(Integer logInstanc) {
        this.logInstanc = logInstanc;
    }

    public String getObjType() {
        return objType;
    }

    public void setObjType(String objType) {
        this.objType = objType;
    }

    public String getSww() {
        return sww;
    }

    public void setSww(String sww) {
        this.sww = sww;
    }

    public Character getDeleted() {
        return deleted;
    }

    public void setDeleted(Character deleted) {
        this.deleted = deleted;
    }

    public Integer getDocEntry() {
        return docEntry;
    }

    public void setDocEntry(Integer docEntry) {
        this.docEntry = docEntry;
    }

    public String getExpensAcct() {
        return expensAcct;
    }

    public void setExpensAcct(String expensAcct) {
        this.expensAcct = expensAcct;
    }

    public String getFrgnInAcct() {
        return frgnInAcct;
    }

    public void setFrgnInAcct(String frgnInAcct) {
        this.frgnInAcct = frgnInAcct;
    }

    public Short getShipType() {
        return shipType;
    }

    public void setShipType(Short shipType) {
        this.shipType = shipType;
    }

    public Character getGLMethod() {
        return gLMethod;
    }

    public void setGLMethod(Character gLMethod) {
        this.gLMethod = gLMethod;
    }

    public String getECInAcct() {
        return eCInAcct;
    }

    public void setECInAcct(String eCInAcct) {
        this.eCInAcct = eCInAcct;
    }

    public String getFrgnExpAcc() {
        return frgnExpAcc;
    }

    public void setFrgnExpAcc(String frgnExpAcc) {
        this.frgnExpAcc = frgnExpAcc;
    }

    public String getECExpAcc() {
        return eCExpAcc;
    }

    public void setECExpAcc(String eCExpAcc) {
        this.eCExpAcc = eCExpAcc;
    }

    public Character getTaxType() {
        return taxType;
    }

    public void setTaxType(Character taxType) {
        this.taxType = taxType;
    }

    public Character getByWh() {
        return byWh;
    }

    public void setByWh(Character byWh) {
        this.byWh = byWh;
    }

    public Character getWTLiable() {
        return wTLiable;
    }

    public void setWTLiable(Character wTLiable) {
        this.wTLiable = wTLiable;
    }

    public Character getItemType() {
        return itemType;
    }

    public void setItemType(Character itemType) {
        this.itemType = itemType;
    }

    public String getWarrntTmpl() {
        return warrntTmpl;
    }

    public void setWarrntTmpl(String warrntTmpl) {
        this.warrntTmpl = warrntTmpl;
    }

    public String getBaseUnit() {
        return baseUnit;
    }

    public void setBaseUnit(String baseUnit) {
        this.baseUnit = baseUnit;
    }

    public String getCountryOrg() {
        return countryOrg;
    }

    public void setCountryOrg(String countryOrg) {
        this.countryOrg = countryOrg;
    }

    public BigDecimal getStockValue() {
        return stockValue;
    }

    public void setStockValue(BigDecimal stockValue) {
        this.stockValue = stockValue;
    }

    public Character getPhantom() {
        return phantom;
    }

    public void setPhantom(Character phantom) {
        this.phantom = phantom;
    }

    public Character getIssueMthd() {
        return issueMthd;
    }

    public void setIssueMthd(Character issueMthd) {
        this.issueMthd = issueMthd;
    }

    public Character getFree1() {
        return free1;
    }

    public void setFree1(Character free1) {
        this.free1 = free1;
    }

    public BigDecimal getPricingPrc() {
        return pricingPrc;
    }

    public void setPricingPrc(BigDecimal pricingPrc) {
        this.pricingPrc = pricingPrc;
    }

    public Character getMngMethod() {
        return mngMethod;
    }

    public void setMngMethod(Character mngMethod) {
        this.mngMethod = mngMethod;
    }

    public BigDecimal getReorderPnt() {
        return reorderPnt;
    }

    public void setReorderPnt(BigDecimal reorderPnt) {
        this.reorderPnt = reorderPnt;
    }

    public String getInvntryUom() {
        return invntryUom;
    }

    public void setInvntryUom(String invntryUom) {
        this.invntryUom = invntryUom;
    }

    public Character getPlaningSys() {
        return planingSys;
    }

    public void setPlaningSys(Character planingSys) {
        this.planingSys = planingSys;
    }

    public Character getPrcrmntMtd() {
        return prcrmntMtd;
    }

    public void setPrcrmntMtd(Character prcrmntMtd) {
        this.prcrmntMtd = prcrmntMtd;
    }

    public Short getOrdrIntrvl() {
        return ordrIntrvl;
    }

    public void setOrdrIntrvl(Short ordrIntrvl) {
        this.ordrIntrvl = ordrIntrvl;
    }

    public BigDecimal getOrdrMulti() {
        return ordrMulti;
    }

    public void setOrdrMulti(BigDecimal ordrMulti) {
        this.ordrMulti = ordrMulti;
    }

    public BigDecimal getMinOrdrQty() {
        return minOrdrQty;
    }

    public void setMinOrdrQty(BigDecimal minOrdrQty) {
        this.minOrdrQty = minOrdrQty;
    }

    public Integer getLeadTime() {
        return leadTime;
    }

    public void setLeadTime(Integer leadTime) {
        this.leadTime = leadTime;
    }

    public Character getIndirctTax() {
        return indirctTax;
    }

    public void setIndirctTax(Character indirctTax) {
        this.indirctTax = indirctTax;
    }

    public String getTaxCodeAR() {
        return taxCodeAR;
    }

    public void setTaxCodeAR(String taxCodeAR) {
        this.taxCodeAR = taxCodeAR;
    }

    public String getTaxCodeAP() {
        return taxCodeAP;
    }

    public void setTaxCodeAP(String taxCodeAP) {
        this.taxCodeAP = taxCodeAP;
    }

    public Integer getOSvcCode() {
        return oSvcCode;
    }

    public void setOSvcCode(Integer oSvcCode) {
        this.oSvcCode = oSvcCode;
    }

    public Integer getISvcCode() {
        return iSvcCode;
    }

    public void setISvcCode(Integer iSvcCode) {
        this.iSvcCode = iSvcCode;
    }

    public Integer getServiceGrp() {
        return serviceGrp;
    }

    public void setServiceGrp(Integer serviceGrp) {
        this.serviceGrp = serviceGrp;
    }

    public Integer getNCMCode() {
        return nCMCode;
    }

    public void setNCMCode(Integer nCMCode) {
        this.nCMCode = nCMCode;
    }

    public String getMatType() {
        return matType;
    }

    public void setMatType(String matType) {
        this.matType = matType;
    }

    public Integer getMatGrp() {
        return matGrp;
    }

    public void setMatGrp(Integer matGrp) {
        this.matGrp = matGrp;
    }

    public String getProductSrc() {
        return productSrc;
    }

    public void setProductSrc(String productSrc) {
        this.productSrc = productSrc;
    }

    public Integer getServiceCtg() {
        return serviceCtg;
    }

    public void setServiceCtg(Integer serviceCtg) {
        this.serviceCtg = serviceCtg;
    }

    public Character getItemClass() {
        return itemClass;
    }

    public void setItemClass(Character itemClass) {
        this.itemClass = itemClass;
    }

    public Character getExcisable() {
        return excisable;
    }

    public void setExcisable(Character excisable) {
        this.excisable = excisable;
    }

    public Integer getChapterID() {
        return chapterID;
    }

    public void setChapterID(Integer chapterID) {
        this.chapterID = chapterID;
    }

    public String getNotifyASN() {
        return notifyASN;
    }

    public void setNotifyASN(String notifyASN) {
        this.notifyASN = notifyASN;
    }

    public String getProAssNum() {
        return proAssNum;
    }

    public void setProAssNum(String proAssNum) {
        this.proAssNum = proAssNum;
    }

    public BigDecimal getAssblValue() {
        return assblValue;
    }

    public void setAssblValue(BigDecimal assblValue) {
        this.assblValue = assblValue;
    }

    public Integer getDNFEntry() {
        return dNFEntry;
    }

    public void setDNFEntry(Integer dNFEntry) {
        this.dNFEntry = dNFEntry;
    }

    public Short getUserSign2() {
        return userSign2;
    }

    public void setUserSign2(Short userSign2) {
        this.userSign2 = userSign2;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getTaxCtg() {
        return taxCtg;
    }

    public void setTaxCtg(String taxCtg) {
        this.taxCtg = taxCtg;
    }

    public Short getSeries() {
        return series;
    }

    public void setSeries(Short series) {
        this.series = series;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getFuelCode() {
        return fuelCode;
    }

    public void setFuelCode(Integer fuelCode) {
        this.fuelCode = fuelCode;
    }

    public String getBeverTblC() {
        return beverTblC;
    }

    public void setBeverTblC(String beverTblC) {
        this.beverTblC = beverTblC;
    }

    public String getBeverGrpC() {
        return beverGrpC;
    }

    public void setBeverGrpC(String beverGrpC) {
        this.beverGrpC = beverGrpC;
    }

    public Integer getBeverTM() {
        return beverTM;
    }

    public void setBeverTM(Integer beverTM) {
        this.beverTM = beverTM;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public Integer getAtcEntry() {
        return atcEntry;
    }

    public void setAtcEntry(Integer atcEntry) {
        this.atcEntry = atcEntry;
    }

    public Integer getToleranDay() {
        return toleranDay;
    }

    public void setToleranDay(Integer toleranDay) {
        this.toleranDay = toleranDay;
    }

    public Integer getUgpEntry() {
        return ugpEntry;
    }

    public void setUgpEntry(Integer ugpEntry) {
        this.ugpEntry = ugpEntry;
    }

    public Integer getPUoMEntry() {
        return pUoMEntry;
    }

    public void setPUoMEntry(Integer pUoMEntry) {
        this.pUoMEntry = pUoMEntry;
    }

    public Integer getSUoMEntry() {
        return sUoMEntry;
    }

    public void setSUoMEntry(Integer sUoMEntry) {
        this.sUoMEntry = sUoMEntry;
    }

    public Integer getIUoMEntry() {
        return iUoMEntry;
    }

    public void setIUoMEntry(Integer iUoMEntry) {
        this.iUoMEntry = iUoMEntry;
    }

    public Short getIssuePriBy() {
        return issuePriBy;
    }

    public void setIssuePriBy(Short issuePriBy) {
        this.issuePriBy = issuePriBy;
    }

    public String getAssetClass() {
        return assetClass;
    }

    public void setAssetClass(String assetClass) {
        this.assetClass = assetClass;
    }

    public String getAssetGroup() {
        return assetGroup;
    }

    public void setAssetGroup(String assetGroup) {
        this.assetGroup = assetGroup;
    }

    public String getInventryNo() {
        return inventryNo;
    }

    public void setInventryNo(String inventryNo) {
        this.inventryNo = inventryNo;
    }

    public Integer getTechnician() {
        return technician;
    }

    public void setTechnician(Integer technician) {
        this.technician = technician;
    }

    public Integer getEmployee() {
        return employee;
    }

    public void setEmployee(Integer employee) {
        this.employee = employee;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public Character getStatAsset() {
        return statAsset;
    }

    public void setStatAsset(Character statAsset) {
        this.statAsset = statAsset;
    }

    public Character getCession() {
        return cession;
    }

    public void setCession(Character cession) {
        this.cession = cession;
    }

    public Character getDeacAftUL() {
        return deacAftUL;
    }

    public void setDeacAftUL(Character deacAftUL) {
        this.deacAftUL = deacAftUL;
    }

    public Character getAsstStatus() {
        return asstStatus;
    }

    public void setAsstStatus(Character asstStatus) {
        this.asstStatus = asstStatus;
    }

    public Date getCapDate() {
        return capDate;
    }

    public void setCapDate(Date capDate) {
        this.capDate = capDate;
    }

    public Date getAcqDate() {
        return acqDate;
    }

    public void setAcqDate(Date acqDate) {
        this.acqDate = acqDate;
    }

    public Date getRetDate() {
        return retDate;
    }

    public void setRetDate(Date retDate) {
        this.retDate = retDate;
    }

    public Character getGLPickMeth() {
        return gLPickMeth;
    }

    public void setGLPickMeth(Character gLPickMeth) {
        this.gLPickMeth = gLPickMeth;
    }

    public Character getNoDiscount() {
        return noDiscount;
    }

    public void setNoDiscount(Character noDiscount) {
        this.noDiscount = noDiscount;
    }

    public Character getMgrByQty() {
        return mgrByQty;
    }

    public void setMgrByQty(Character mgrByQty) {
        this.mgrByQty = mgrByQty;
    }

    public String getAssetRmk1() {
        return assetRmk1;
    }

    public void setAssetRmk1(String assetRmk1) {
        this.assetRmk1 = assetRmk1;
    }

    public String getAssetRmk2() {
        return assetRmk2;
    }

    public void setAssetRmk2(String assetRmk2) {
        this.assetRmk2 = assetRmk2;
    }

    public BigDecimal getAssetAmnt1() {
        return assetAmnt1;
    }

    public void setAssetAmnt1(BigDecimal assetAmnt1) {
        this.assetAmnt1 = assetAmnt1;
    }

    public BigDecimal getAssetAmnt2() {
        return assetAmnt2;
    }

    public void setAssetAmnt2(BigDecimal assetAmnt2) {
        this.assetAmnt2 = assetAmnt2;
    }

    public String getDeprGroup() {
        return deprGroup;
    }

    public void setDeprGroup(String deprGroup) {
        this.deprGroup = deprGroup;
    }

    public String getAssetSerNo() {
        return assetSerNo;
    }

    public void setAssetSerNo(String assetSerNo) {
        this.assetSerNo = assetSerNo;
    }

    public String getCntUnitMsr() {
        return cntUnitMsr;
    }

    public void setCntUnitMsr(String cntUnitMsr) {
        this.cntUnitMsr = cntUnitMsr;
    }

    public BigDecimal getNumInCnt() {
        return numInCnt;
    }

    public void setNumInCnt(BigDecimal numInCnt) {
        this.numInCnt = numInCnt;
    }

    public Integer getINUoMEntry() {
        return iNUoMEntry;
    }

    public void setINUoMEntry(Integer iNUoMEntry) {
        this.iNUoMEntry = iNUoMEntry;
    }

    public Character getOneBOneRec() {
        return oneBOneRec;
    }

    public void setOneBOneRec(Character oneBOneRec) {
        this.oneBOneRec = oneBOneRec;
    }

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

    public String getScsCode() {
        return scsCode;
    }

    public void setScsCode(String scsCode) {
        this.scsCode = scsCode;
    }

    public String getSpProdType() {
        return spProdType;
    }

    public void setSpProdType(String spProdType) {
        this.spProdType = spProdType;
    }

    public BigDecimal getIWeight1() {
        return iWeight1;
    }

    public void setIWeight1(BigDecimal iWeight1) {
        this.iWeight1 = iWeight1;
    }

    public Short getIWght1Unit() {
        return iWght1Unit;
    }

    public void setIWght1Unit(Short iWght1Unit) {
        this.iWght1Unit = iWght1Unit;
    }

    public BigDecimal getIWeight2() {
        return iWeight2;
    }

    public void setIWeight2(BigDecimal iWeight2) {
        this.iWeight2 = iWeight2;
    }

    public Short getIWght2Unit() {
        return iWght2Unit;
    }

    public void setIWght2Unit(Short iWght2Unit) {
        this.iWght2Unit = iWght2Unit;
    }

    public Character getCompoWH() {
        return compoWH;
    }

    public void setCompoWH(Character compoWH) {
        this.compoWH = compoWH;
    }

    public Integer getCreateTS() {
        return createTS;
    }

    public void setCreateTS(Integer createTS) {
        this.createTS = createTS;
    }

    public Integer getUpdateTS() {
        return updateTS;
    }

    public void setUpdateTS(Integer updateTS) {
        this.updateTS = updateTS;
    }

    public Character getVirtAstItm() {
        return virtAstItm;
    }

    public void setVirtAstItm(Character virtAstItm) {
        this.virtAstItm = virtAstItm;
    }

    public String getSouVirAsst() {
        return souVirAsst;
    }

    public void setSouVirAsst(String souVirAsst) {
        this.souVirAsst = souVirAsst;
    }

    public Character getInCostRoll() {
        return inCostRoll;
    }

    public void setInCostRoll(Character inCostRoll) {
        this.inCostRoll = inCostRoll;
    }

    public BigDecimal getPrdStdCst() {
        return prdStdCst;
    }

    public void setPrdStdCst(BigDecimal prdStdCst) {
        this.prdStdCst = prdStdCst;
    }

    public Character getEnAstSeri() {
        return enAstSeri;
    }

    public void setEnAstSeri(Character enAstSeri) {
        this.enAstSeri = enAstSeri;
    }

    public String getLinkRsc() {
        return linkRsc;
    }

    public void setLinkRsc(String linkRsc) {
        this.linkRsc = linkRsc;
    }

    public BigDecimal getOnHldPert() {
        return onHldPert;
    }

    public void setOnHldPert(BigDecimal onHldPert) {
        this.onHldPert = onHldPert;
    }

    public BigDecimal getOnHldLimt() {
        return onHldLimt;
    }

    public void setOnHldLimt(BigDecimal onHldLimt) {
        this.onHldLimt = onHldLimt;
    }

    public Character getGSTRelevnt() {
        return gSTRelevnt;
    }

    public void setGSTRelevnt(Character gSTRelevnt) {
        this.gSTRelevnt = gSTRelevnt;
    }

    public Integer getSACEntry() {
        return sACEntry;
    }

    public void setSACEntry(Integer sACEntry) {
        this.sACEntry = sACEntry;
    }

    public Character getGstTaxCtg() {
        return gstTaxCtg;
    }

    public void setGstTaxCtg(Character gstTaxCtg) {
        this.gstTaxCtg = gstTaxCtg;
    }

    public String getUIGroup() {
        return uIGroup;
    }

    public void setUIGroup(String uIGroup) {
        this.uIGroup = uIGroup;
    }

    public String getUSubgr() {
        return uSubgr;
    }

    public void setUSubgr(String uSubgr) {
        this.uSubgr = uSubgr;
    }

    public String getURdcode() {
        return uRdcode;
    }

    public void setURdcode(String uRdcode) {
        this.uRdcode = uRdcode;
    }

    public String getUIGroupName() {
        return uIGroupName;
    }

    public void setUIGroupName(String uIGroupName) {
        this.uIGroupName = uIGroupName;
    }

    public String getUSUBGRName() {
        return uSUBGRName;
    }

    public void setUSUBGRName(String uSUBGRName) {
        this.uSUBGRName = uSUBGRName;
    }

    public String getUProductBranch() {
        return uProductBranch;
    }

    public void setUProductBranch(String uProductBranch) {
        this.uProductBranch = uProductBranch;
    }

    public String getUProductGroup() {
        return uProductGroup;
    }

    public void setUProductGroup(String uProductGroup) {
        this.uProductGroup = uProductGroup;
    }

    public String getUForcast() {
        return uForcast;
    }

    public void setUForcast(String uForcast) {
        this.uForcast = uForcast;
    }

    public String getUShortName() {
        return uShortName;
    }

    public void setUShortName(String uShortName) {
        this.uShortName = uShortName;
    }

    public String getUTechName() {
        return uTechName;
    }

    public void setUTechName(String uTechName) {
        this.uTechName = uTechName;
    }

    public String getUDGroup() {
        return uDGroup;
    }

    public void setUDGroup(String uDGroup) {
        this.uDGroup = uDGroup;
    }

    public String getUDGroupName() {
        return uDGroupName;
    }

    public void setUDGroupName(String uDGroupName) {
        this.uDGroupName = uDGroupName;
    }

    public BigDecimal getUPackage() {
        return uPackage;
    }

    public void setUPackage(BigDecimal uPackage) {
        this.uPackage = uPackage;
    }

    public String getUMsl() {
        return uMsl;
    }

    public void setUMsl(String uMsl) {
        this.uMsl = uMsl;
    }

    public String getUPartNumber() {
        return uPartNumber;
    }

    public void setUPartNumber(String uPartNumber) {
        this.uPartNumber = uPartNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemCode != null ? itemCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oitm)) {
            return false;
        }
        Oitm other = (Oitm) object;
        if ((this.itemCode == null && other.itemCode != null) || (this.itemCode != null && !this.itemCode.equals(other.itemCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication4.Oitm[ itemCode=" + itemCode + " ]";
    }
    
}
