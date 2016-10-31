package com.coherentlogic.treasurydirect.client.core.domain;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import com.coherentlogic.coherent.data.model.core.annotations.Changeable;
import com.coherentlogic.coherent.data.model.core.domain.SerializableBean;

/**
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class Debt extends SerializableBean<Debt> {

    private static final long serialVersionUID = -612868509031408211L;

    private String effectiveDate;

    /**
     * Getter method for the effectiveDate property.
     */
    public String getEffectiveDate () {
        return effectiveDate;
    }

    /**
     * Getter method for the effectiveDate property as an instance of {@link java.util.Date}.
     *
     * @throws ParseException 
     */
    public Date getEffectiveDate (DateFormat dateFormat) throws ParseException {
        return dateFormat.parse(effectiveDate);
    }

    public static final String EFFECTIVE_DATE = "effectiveDate";

    /**
     * Setter method for the effectiveDate property.
     */
    public void setEffectiveDate (@Changeable(EFFECTIVE_DATE) String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    private String governmentHoldings;

    /**
     * Getter method for the governmentHoldings property.
     */
    public String getGovernmentHoldings () {
        return governmentHoldings;
    }

    public BigDecimal getGovernmentHoldingsAsBigDecimal () {
        return new BigDecimal (governmentHoldings);
    }

    public BigDecimal getGovernmentHoldingsAsBigDecimal (MathContext mathContext) {
        return new BigDecimal (governmentHoldings, mathContext);
    }

    public static final String GOVERNMENT_HOLDINGS = "governmentHoldings";

    /**
     * Setter method for the governmentHoldings property.
     */
    public void setGovernmentHoldings (@Changeable(GOVERNMENT_HOLDINGS) String governmentHoldings) {
        this.governmentHoldings = governmentHoldings;
    }

    private String publicDebt;

    /**
     * Getter method for the publicDebt property.
     */
    public String getPublicDebt () {
        return publicDebt;
    }

    public static final String PUBLIC_DEBT = "publicDebt";

    /**
     * Setter method for the publicDebt property.
     */
    public void setPublicDebt (@Changeable(PUBLIC_DEBT) String publicDebt) {
        this.publicDebt = publicDebt;
    }

    /**
     * Getter method for the publicDebt property as a {@link BigDecimal}.
     */
    public BigDecimal getPublicDebtAsBigDecimal () {
        return new BigDecimal (publicDebt);
    }

    /**
     * Getter method for the publicDebt property as a {@link BigDecimal} and allows the developer to pass in an instance
     * of {@link MathContext}.
     */
    public BigDecimal getPublicDebtAsBigDecimal (MathContext mathContext) {
        return new BigDecimal (publicDebt, mathContext);
    }

    private String totalDebt;

    /**
     * Getter method for the totalDebt property.
     */
    public String getTotalDebt () {
        return totalDebt;
    }

    public static final String TOTAL_DEBT = "totalDebt";

    /**
     * Setter method for the totalDebt property.
     */
    public void setTotalDebt (@Changeable(TOTAL_DEBT) String totalDebt) {
        this.totalDebt = totalDebt;
    }

    /**
     * Getter method for the publicDebt property as a {@link BigDecimal}.
     */
    public BigDecimal getTotalDebtAsBigDecimal () {
        return new BigDecimal (totalDebt);
    }

    /**
     * Getter method for the publicDebt property as a {@link BigDecimal} and allows the developer to pass in an instance
     * of {@link MathContext}.
     */
    public BigDecimal getTotalDebtAsBigDecimal (MathContext mathContext) {
        return new BigDecimal (totalDebt, mathContext);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((effectiveDate == null) ? 0 : effectiveDate.hashCode());
        result = prime * result + ((governmentHoldings == null) ? 0 : governmentHoldings.hashCode());
        result = prime * result + ((publicDebt == null) ? 0 : publicDebt.hashCode());
        result = prime * result + ((totalDebt == null) ? 0 : totalDebt.hashCode());
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
        Debt other = (Debt) obj;
        if (effectiveDate == null) {
            if (other.effectiveDate != null)
                return false;
        } else if (!effectiveDate.equals(other.effectiveDate))
            return false;
        if (governmentHoldings == null) {
            if (other.governmentHoldings != null)
                return false;
        } else if (!governmentHoldings.equals(other.governmentHoldings))
            return false;
        if (publicDebt == null) {
            if (other.publicDebt != null)
                return false;
        } else if (!publicDebt.equals(other.publicDebt))
            return false;
        if (totalDebt == null) {
            if (other.totalDebt != null)
                return false;
        } else if (!totalDebt.equals(other.totalDebt))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Debt [effectiveDate=" + effectiveDate + ", governmentHoldings=" + governmentHoldings + ", publicDebt="
            + publicDebt + ", totalDebt=" + totalDebt + ", toString()=" + super.toString() + "]";
    }
}
