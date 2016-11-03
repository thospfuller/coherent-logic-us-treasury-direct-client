package com.coherentlogic.treasurydirect.client.core.domain;

import java.util.List;

import com.coherentlogic.coherent.data.model.core.domain.SerializableBean;

/**
 * Top-level representation of debt data returned from calls to the treasurydirect.gov web services.
 *
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class Debts extends SerializableBean<Debts> {

    private static final long serialVersionUID = -1997617185138107698L;

    private List<Debt> debtList = null;

    public List<Debt> getDebtList() {
        return debtList;
    }

    public void setDebtList(List<Debt> debtList) {
        this.debtList = debtList;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((debtList == null) ? 0 : debtList.hashCode());
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
        Debts other = (Debts) obj;
        if (debtList == null) {
            if (other.debtList != null)
                return false;
        } else if (!debtList.equals(other.debtList))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Debts [debtList=" + debtList + ", toString()=" + super.toString() + "]";
    }
}
