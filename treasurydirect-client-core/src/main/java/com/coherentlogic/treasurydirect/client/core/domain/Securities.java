package com.coherentlogic.treasurydirect.client.core.domain;

import java.util.List;

import com.coherentlogic.coherent.data.model.core.domain.SerializableBean;

/**
 * http://www.treasurydirect.gov/TA_WS/securities/912796CJ6/02/11/2014?format=json
 * @author Thomas P. Fuller
 *
 */
public class Securities extends SerializableBean<Securities> {

    private List<Security> securityList = null;

    public List<Security> getSecurityList() {
        return securityList;
    }

    public void setSecurityList(List<Security> securityList) {
        this.securityList = securityList;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((securityList == null) ? 0 : securityList.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Securities other = (Securities) obj;
        if (securityList == null) {
            if (other.securityList != null)
                return false;
        } else if (!securityList.equals(other.securityList))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Securities [securityList=" + securityList + ", getCreatedDate()=" + getCreatedDate()
            + ", getUpdatedDate()=" + getUpdatedDate() + ", getVersion()=" + getVersion() + ", getPrimaryKey()="
            + getPrimaryKey() + ", getVetoableChangeSupport()=" + getVetoableChangeSupport()
            + ", getPropertyChangeSupport()=" + getPropertyChangeSupport()
            + ", getAggregatePropertyChangeListeners()=" + getAggregatePropertyChangeListeners() + ", hashCode()="
            + hashCode() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + "]";
    }
}
