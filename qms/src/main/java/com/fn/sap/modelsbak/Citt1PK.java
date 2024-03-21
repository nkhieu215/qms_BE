/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fn.sap.modelsbak;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Dong
 */
@Embeddable
public class Citt1PK implements Serializable {
    @Basic(optional = false)
    @Column(name = "DocEntry")
    private int docEntry;
    @Basic(optional = false)
    @Column(name = "LineId")
    private int lineId;

    public Citt1PK() {
    }

    public Citt1PK(int docEntry, int lineId) {
        this.docEntry = docEntry;
        this.lineId = lineId;
    }

    public int getDocEntry() {
        return docEntry;
    }

    public void setDocEntry(int docEntry) {
        this.docEntry = docEntry;
    }

    public int getLineId() {
        return lineId;
    }

    public void setLineId(int lineId) {
        this.lineId = lineId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) docEntry;
        hash += (int) lineId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Citt1PK)) {
            return false;
        }
        Citt1PK other = (Citt1PK) object;
        if (this.docEntry != other.docEntry) {
            return false;
        }
        if (this.lineId != other.lineId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication4.Citt1PK[ docEntry=" + docEntry + ", lineId=" + lineId + " ]";
    }
    
}
