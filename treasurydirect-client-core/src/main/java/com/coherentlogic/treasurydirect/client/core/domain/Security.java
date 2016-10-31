package com.coherentlogic.treasurydirect.client.core.domain;

import com.coherentlogic.coherent.data.model.core.annotations.Changeable;
import com.coherentlogic.coherent.data.model.core.domain.SerializableBean;

public class Security extends SerializableBean<Security> {


    private String cusip;

    /**
     * Getter method for the cusip property.
     */
    public String getCusip () {
        return cusip;
    }

    public static final String CUSIP = "cusip";

    /**
     * Setter method for the cusip property.
     */
    public void setCusip (@Changeable(CUSIP) String cusip) {
        this.cusip = cusip;
    }

    private String issueDate;

    /**
     * Getter method for the issueDate property.
     */
    public String getIssueDate () {
        return issueDate;
    }

    public static final String ISSUEDATE = "issueDate";

    /**
     * Setter method for the issueDate property.
     */
    public void setIssueDate (@Changeable(ISSUEDATE) String issueDate) {
        this.issueDate = issueDate;
    }

    private String securityType;

    /**
     * Getter method for the securityType property.
     */
    public String getSecurityType () {
        return securityType;
    }

    public static final String SECURITYTYPE = "securityType";

    /**
     * Setter method for the securityType property.
     */
    public void setSecurityType (@Changeable(SECURITYTYPE) String securityType) {
        this.securityType = securityType;
    }

    private String securityTerm;

    /**
     * Getter method for the securityTerm property.
     */
    public String getSecurityTerm () {
        return securityTerm;
    }

    public static final String SECURITYTERM = "securityTerm";

    /**
     * Setter method for the securityTerm property.
     */
    public void setSecurityTerm (@Changeable(SECURITYTERM) String securityTerm) {
        this.securityTerm = securityTerm;
    }

    private String maturityDate;

    /**
     * Getter method for the maturityDate property.
     */
    public String getMaturityDate () {
        return maturityDate;
    }

    public static final String MATURITYDATE = "maturityDate";

    /**
     * Setter method for the maturityDate property.
     */
    public void setMaturityDate (@Changeable(MATURITYDATE) String maturityDate) {
        this.maturityDate = maturityDate;
    }

    private String interestRate;

    /**
     * Getter method for the interestRate property.
     */
    public String getInterestRate () {
        return interestRate;
    }

    public static final String INTERESTRATE = "interestRate";

    /**
     * Setter method for the interestRate property.
     */
    public void setInterestRate (@Changeable(INTERESTRATE) String interestRate) {
        this.interestRate = interestRate;
    }

    private String refCpiOnIssueDate;

    /**
     * Getter method for the refCpiOnIssueDate property.
     */
    public String getRefCpiOnIssueDate () {
        return refCpiOnIssueDate;
    }

    public static final String REFCPIONISSUEDATE = "refCpiOnIssueDate";

    /**
     * Setter method for the refCpiOnIssueDate property.
     */
    public void setRefCpiOnIssueDate (@Changeable(REFCPIONISSUEDATE) String refCpiOnIssueDate) {
        this.refCpiOnIssueDate = refCpiOnIssueDate;
    }

    private String refCpiOnDatedDate;

    /**
     * Getter method for the refCpiOnDatedDate property.
     */
    public String getRefCpiOnDatedDate () {
        return refCpiOnDatedDate;
    }

    public static final String REFCPIONDATEDDATE = "refCpiOnDatedDate";

    /**
     * Setter method for the refCpiOnDatedDate property.
     */
    public void setRefCpiOnDatedDate (@Changeable(REFCPIONDATEDDATE) String refCpiOnDatedDate) {
        this.refCpiOnDatedDate = refCpiOnDatedDate;
    }

    private String announcementDate;

    /**
     * Getter method for the announcementDate property.
     */
    public String getAnnouncementDate () {
        return announcementDate;
    }

    public static final String ANNOUNCEMENTDATE = "announcementDate";

    /**
     * Setter method for the announcementDate property.
     */
    public void setAnnouncementDate (@Changeable(ANNOUNCEMENTDATE) String announcementDate) {
        this.announcementDate = announcementDate;
    }

    private String auctionDate;

    /**
     * Getter method for the auctionDate property.
     */
    public String getAuctionDate () {
        return auctionDate;
    }

    public static final String AUCTIONDATE = "auctionDate";

    /**
     * Setter method for the auctionDate property.
     */
    public void setAuctionDate (@Changeable(AUCTIONDATE) String auctionDate) {
        this.auctionDate = auctionDate;
    }

    private String auctionDateYear;

    /**
     * Getter method for the auctionDateYear property.
     */
    public String getAuctionDateYear () {
        return auctionDateYear;
    }

    public static final String AUCTIONDATEYEAR = "auctionDateYear";

    /**
     * Setter method for the auctionDateYear property.
     */
    public void setAuctionDateYear (@Changeable(AUCTIONDATEYEAR) String auctionDateYear) {
        this.auctionDateYear = auctionDateYear;
    }

    private String datedDate;

    /**
     * Getter method for the datedDate property.
     */
    public String getDatedDate () {
        return datedDate;
    }

    public static final String DATEDDATE = "datedDate";

    /**
     * Setter method for the datedDate property.
     */
    public void setDatedDate (@Changeable(DATEDDATE) String datedDate) {
        this.datedDate = datedDate;
    }

    private String accruedInterestPer1000;

    /**
     * Getter method for the accruedInterestPer1000 property.
     */
    public String getAccruedInterestPer1000 () {
        return accruedInterestPer1000;
    }

    public static final String ACCRUEDINTERESTPER1000 = "accruedInterestPer1000";

    /**
     * Setter method for the accruedInterestPer1000 property.
     */
    public void setAccruedInterestPer1000 (@Changeable(ACCRUEDINTERESTPER1000) String accruedInterestPer1000) {
        this.accruedInterestPer1000 = accruedInterestPer1000;
    }

    private String accruedInterestPer100;

    /**
     * Getter method for the accruedInterestPer100 property.
     */
    public String getAccruedInterestPer100 () {
        return accruedInterestPer100;
    }

    public static final String ACCRUEDINTERESTPER100 = "accruedInterestPer100";

    /**
     * Setter method for the accruedInterestPer100 property.
     */
    public void setAccruedInterestPer100 (@Changeable(ACCRUEDINTERESTPER100) String accruedInterestPer100) {
        this.accruedInterestPer100 = accruedInterestPer100;
    }

    private String adjustedAccruedInterestPer1000;

    /**
     * Getter method for the adjustedAccruedInterestPer1000 property.
     */
    public String getAdjustedAccruedInterestPer1000 () {
        return adjustedAccruedInterestPer1000;
    }

    public static final String ADJUSTEDACCRUEDINTERESTPER1000 = "adjustedAccruedInterestPer1000";

    /**
     * Setter method for the adjustedAccruedInterestPer1000 property.
     */
    public void setAdjustedAccruedInterestPer1000 (@Changeable(ADJUSTEDACCRUEDINTERESTPER1000) String adjustedAccruedInterestPer1000) {
        this.adjustedAccruedInterestPer1000 = adjustedAccruedInterestPer1000;
    }

    private String adjustedPrice;

    /**
     * Getter method for the adjustedPrice property.
     */
    public String getAdjustedPrice () {
        return adjustedPrice;
    }

    public static final String ADJUSTEDPRICE = "adjustedPrice";

    /**
     * Setter method for the adjustedPrice property.
     */
    public void setAdjustedPrice (@Changeable(ADJUSTEDPRICE) String adjustedPrice) {
        this.adjustedPrice = adjustedPrice;
    }

    private String allocationPercentage;

    /**
     * Getter method for the allocationPercentage property.
     */
    public String getAllocationPercentage () {
        return allocationPercentage;
    }

    public static final String ALLOCATIONPERCENTAGE = "allocationPercentage";

    /**
     * Setter method for the allocationPercentage property.
     */
    public void setAllocationPercentage (@Changeable(ALLOCATIONPERCENTAGE) String allocationPercentage) {
        this.allocationPercentage = allocationPercentage;
    }

    private String allocationPercentageDecimals;

    /**
     * Getter method for the allocationPercentageDecimals property.
     */
    public String getAllocationPercentageDecimals () {
        return allocationPercentageDecimals;
    }

    public static final String ALLOCATIONPERCENTAGEDECIMALS = "allocationPercentageDecimals";

    /**
     * Setter method for the allocationPercentageDecimals property.
     */
    public void setAllocationPercentageDecimals (@Changeable(ALLOCATIONPERCENTAGEDECIMALS) String allocationPercentageDecimals) {
        this.allocationPercentageDecimals = allocationPercentageDecimals;
    }

    private String announcedCusip;

    /**
     * Getter method for the announcedCusip property.
     */
    public String getAnnouncedCusip () {
        return announcedCusip;
    }

    public static final String ANNOUNCEDCUSIP = "announcedCusip";

    /**
     * Setter method for the announcedCusip property.
     */
    public void setAnnouncedCusip (@Changeable(ANNOUNCEDCUSIP) String announcedCusip) {
        this.announcedCusip = announcedCusip;
    }

    private String auctionFormat;

    /**
     * Getter method for the auctionFormat property.
     */
    public String getAuctionFormat () {
        return auctionFormat;
    }

    public static final String AUCTIONFORMAT = "auctionFormat";

    /**
     * Setter method for the auctionFormat property.
     */
    public void setAuctionFormat (@Changeable(AUCTIONFORMAT) String auctionFormat) {
        this.auctionFormat = auctionFormat;
    }

    private String averageMedianDiscountRate;

    /**
     * Getter method for the averageMedianDiscountRate property.
     */
    public String getAverageMedianDiscountRate () {
        return averageMedianDiscountRate;
    }

    public static final String AVERAGEMEDIANDISCOUNTRATE = "averageMedianDiscountRate";

    /**
     * Setter method for the averageMedianDiscountRate property.
     */
    public void setAverageMedianDiscountRate (@Changeable(AVERAGEMEDIANDISCOUNTRATE) String averageMedianDiscountRate) {
        this.averageMedianDiscountRate = averageMedianDiscountRate;
    }

    private String averageMedianInvestmentRate;

    /**
     * Getter method for the averageMedianInvestmentRate property.
     */
    public String getAverageMedianInvestmentRate () {
        return averageMedianInvestmentRate;
    }

    public static final String AVERAGEMEDIANINVESTMENTRATE = "averageMedianInvestmentRate";

    /**
     * Setter method for the averageMedianInvestmentRate property.
     */
    public void setAverageMedianInvestmentRate (@Changeable(AVERAGEMEDIANINVESTMENTRATE) String averageMedianInvestmentRate) {
        this.averageMedianInvestmentRate = averageMedianInvestmentRate;
    }

    private String averageMedianPrice;

    /**
     * Getter method for the averageMedianPrice property.
     */
    public String getAverageMedianPrice () {
        return averageMedianPrice;
    }

    public static final String AVERAGEMEDIANPRICE = "averageMedianPrice";

    /**
     * Setter method for the averageMedianPrice property.
     */
    public void setAverageMedianPrice (@Changeable(AVERAGEMEDIANPRICE) String averageMedianPrice) {
        this.averageMedianPrice = averageMedianPrice;
    }

    private String averageMedianDiscountMargin;

    /**
     * Getter method for the averageMedianDiscountMargin property.
     */
    public String getAverageMedianDiscountMargin () {
        return averageMedianDiscountMargin;
    }

    public static final String AVERAGEMEDIANDISCOUNTMARGIN = "averageMedianDiscountMargin";

    /**
     * Setter method for the averageMedianDiscountMargin property.
     */
    public void setAverageMedianDiscountMargin (@Changeable(AVERAGEMEDIANDISCOUNTMARGIN) String averageMedianDiscountMargin) {
        this.averageMedianDiscountMargin = averageMedianDiscountMargin;
    }

    private String averageMedianYield;

    /**
     * Getter method for the averageMedianYield property.
     */
    public String getAverageMedianYield () {
        return averageMedianYield;
    }

    public static final String AVERAGEMEDIANYIELD = "averageMedianYield";

    /**
     * Setter method for the averageMedianYield property.
     */
    public void setAverageMedianYield (@Changeable(AVERAGEMEDIANYIELD) String averageMedianYield) {
        this.averageMedianYield = averageMedianYield;
    }

    private String backDated;

    /**
     * Getter method for the backDated property.
     */
    public String getBackDated () {
        return backDated;
    }

    public static final String BACKDATED = "backDated";

    /**
     * Setter method for the backDated property.
     */
    public void setBackDated (@Changeable(BACKDATED) String backDated) {
        this.backDated = backDated;
    }

    private String backDatedDate;

    /**
     * Getter method for the backDatedDate property.
     */
    public String getBackDatedDate () {
        return backDatedDate;
    }

    public static final String BACKDATEDDATE = "backDatedDate";

    /**
     * Setter method for the backDatedDate property.
     */
    public void setBackDatedDate (@Changeable(BACKDATEDDATE) String backDatedDate) {
        this.backDatedDate = backDatedDate;
    }

    private String bidToCoverRatio;

    /**
     * Getter method for the bidToCoverRatio property.
     */
    public String getBidToCoverRatio () {
        return bidToCoverRatio;
    }

    public static final String BIDTOCOVERRATIO = "bidToCoverRatio";

    /**
     * Setter method for the bidToCoverRatio property.
     */
    public void setBidToCoverRatio (@Changeable(BIDTOCOVERRATIO) String bidToCoverRatio) {
        this.bidToCoverRatio = bidToCoverRatio;
    }

    private String callDate;

    /**
     * Getter method for the callDate property.
     */
    public String getCallDate () {
        return callDate;
    }

    public static final String CALLDATE = "callDate";

    /**
     * Setter method for the callDate property.
     */
    public void setCallDate (@Changeable(CALLDATE) String callDate) {
        this.callDate = callDate;
    }

    private String callable;

    /**
     * Getter method for the callable property.
     */
    public String getCallable () {
        return callable;
    }

    public static final String CALLABLE = "callable";

    /**
     * Setter method for the callable property.
     */
    public void setCallable (@Changeable(CALLABLE) String callable) {
        this.callable = callable;
    }

    private String calledDate;

    /**
     * Getter method for the calledDate property.
     */
    public String getCalledDate () {
        return calledDate;
    }

    public static final String CALLEDDATE = "calledDate";

    /**
     * Setter method for the calledDate property.
     */
    public void setCalledDate (@Changeable(CALLEDDATE) String calledDate) {
        this.calledDate = calledDate;
    }

    private String cashManagementBillCMB;

    /**
     * Getter method for the cashManagementBillCMB property.
     */
    public String getCashManagementBillCMB () {
        return cashManagementBillCMB;
    }

    public static final String CASHMANAGEMENTBILLCMB = "cashManagementBillCMB";

    /**
     * Setter method for the cashManagementBillCMB property.
     */
    public void setCashManagementBillCMB (@Changeable(CASHMANAGEMENTBILLCMB) String cashManagementBillCMB) {
        this.cashManagementBillCMB = cashManagementBillCMB;
    }

    private String closingTimeCompetitive;

    /**
     * Getter method for the closingTimeCompetitive property.
     */
    public String getClosingTimeCompetitive () {
        return closingTimeCompetitive;
    }

    public static final String CLOSINGTIMECOMPETITIVE = "closingTimeCompetitive";

    /**
     * Setter method for the closingTimeCompetitive property.
     */
    public void setClosingTimeCompetitive (@Changeable(CLOSINGTIMECOMPETITIVE) String closingTimeCompetitive) {
        this.closingTimeCompetitive = closingTimeCompetitive;
    }

    private String closingTimeNoncompetitive;

    /**
     * Getter method for the closingTimeNoncompetitive property.
     */
    public String getClosingTimeNoncompetitive () {
        return closingTimeNoncompetitive;
    }

    public static final String CLOSINGTIMENONCOMPETITIVE = "closingTimeNoncompetitive";

    /**
     * Setter method for the closingTimeNoncompetitive property.
     */
    public void setClosingTimeNoncompetitive (@Changeable(CLOSINGTIMENONCOMPETITIVE) String closingTimeNoncompetitive) {
        this.closingTimeNoncompetitive = closingTimeNoncompetitive;
    }

    private String competitiveAccepted;

    /**
     * Getter method for the competitiveAccepted property.
     */
    public String getCompetitiveAccepted () {
        return competitiveAccepted;
    }

    public static final String COMPETITIVEACCEPTED = "competitiveAccepted";

    /**
     * Setter method for the competitiveAccepted property.
     */
    public void setCompetitiveAccepted (@Changeable(COMPETITIVEACCEPTED) String competitiveAccepted) {
        this.competitiveAccepted = competitiveAccepted;
    }

    private String competitiveBidDecimals;

    /**
     * Getter method for the competitiveBidDecimals property.
     */
    public String getCompetitiveBidDecimals () {
        return competitiveBidDecimals;
    }

    public static final String COMPETITIVEBIDDECIMALS = "competitiveBidDecimals";

    /**
     * Setter method for the competitiveBidDecimals property.
     */
    public void setCompetitiveBidDecimals (@Changeable(COMPETITIVEBIDDECIMALS) String competitiveBidDecimals) {
        this.competitiveBidDecimals = competitiveBidDecimals;
    }

    private String competitiveTendered;

    /**
     * Getter method for the competitiveTendered property.
     */
    public String getCompetitiveTendered () {
        return competitiveTendered;
    }

    public static final String COMPETITIVETENDERED = "competitiveTendered";

    /**
     * Setter method for the competitiveTendered property.
     */
    public void setCompetitiveTendered (@Changeable(COMPETITIVETENDERED) String competitiveTendered) {
        this.competitiveTendered = competitiveTendered;
    }

    private String competitiveTendersAccepted;

    /**
     * Getter method for the competitiveTendersAccepted property.
     */
    public String getCompetitiveTendersAccepted () {
        return competitiveTendersAccepted;
    }

    public static final String COMPETITIVETENDERSACCEPTED = "competitiveTendersAccepted";

    /**
     * Setter method for the competitiveTendersAccepted property.
     */
    public void setCompetitiveTendersAccepted (@Changeable(COMPETITIVETENDERSACCEPTED) String competitiveTendersAccepted) {
        this.competitiveTendersAccepted = competitiveTendersAccepted;
    }

    private String corpusCusip;

    /**
     * Getter method for the corpusCusip property.
     */
    public String getCorpusCusip () {
        return corpusCusip;
    }

    public static final String CORPUSCUSIP = "corpusCusip";

    /**
     * Setter method for the corpusCusip property.
     */
    public void setCorpusCusip (@Changeable(CORPUSCUSIP) String corpusCusip) {
        this.corpusCusip = corpusCusip;
    }

    private String cpiBaseReferencePeriod;

    /**
     * Getter method for the cpiBaseReferencePeriod property.
     */
    public String getCpiBaseReferencePeriod () {
        return cpiBaseReferencePeriod;
    }

    public static final String CPIBASEREFERENCEPERIOD = "cpiBaseReferencePeriod";

    /**
     * Setter method for the cpiBaseReferencePeriod property.
     */
    public void setCpiBaseReferencePeriod (@Changeable(CPIBASEREFERENCEPERIOD) String cpiBaseReferencePeriod) {
        this.cpiBaseReferencePeriod = cpiBaseReferencePeriod;
    }

    private String currentlyOutstanding;

    /**
     * Getter method for the currentlyOutstanding property.
     */
    public String getCurrentlyOutstanding () {
        return currentlyOutstanding;
    }

    public static final String CURRENTLYOUTSTANDING = "currentlyOutstanding";

    /**
     * Setter method for the currentlyOutstanding property.
     */
    public void setCurrentlyOutstanding (@Changeable(CURRENTLYOUTSTANDING) String currentlyOutstanding) {
        this.currentlyOutstanding = currentlyOutstanding;
    }

    private String directBidderAccepted;

    /**
     * Getter method for the directBidderAccepted property.
     */
    public String getDirectBidderAccepted () {
        return directBidderAccepted;
    }

    public static final String DIRECTBIDDERACCEPTED = "directBidderAccepted";

    /**
     * Setter method for the directBidderAccepted property.
     */
    public void setDirectBidderAccepted (@Changeable(DIRECTBIDDERACCEPTED) String directBidderAccepted) {
        this.directBidderAccepted = directBidderAccepted;
    }

    private String directBidderTendered;

    /**
     * Getter method for the directBidderTendered property.
     */
    public String getDirectBidderTendered () {
        return directBidderTendered;
    }

    public static final String DIRECTBIDDERTENDERED = "directBidderTendered";

    /**
     * Setter method for the directBidderTendered property.
     */
    public void setDirectBidderTendered (@Changeable(DIRECTBIDDERTENDERED) String directBidderTendered) {
        this.directBidderTendered = directBidderTendered;
    }

    private String estimatedAmountOfPubliclyHeldMaturingSecuritiesByType;

    /**
     * Getter method for the estimatedAmountOfPubliclyHeldMaturingSecuritiesByType property.
     */
    public String getEstimatedAmountOfPubliclyHeldMaturingSecuritiesByType () {
        return estimatedAmountOfPubliclyHeldMaturingSecuritiesByType;
    }

    public static final String ESTIMATEDAMOUNTOFPUBLICLYHELDMATURINGSECURITIESBYTYPE = "estimatedAmountOfPubliclyHeldMaturingSecuritiesByType";

    /**
     * Setter method for the estimatedAmountOfPubliclyHeldMaturingSecuritiesByType property.
     */
    public void setEstimatedAmountOfPubliclyHeldMaturingSecuritiesByType (@Changeable(ESTIMATEDAMOUNTOFPUBLICLYHELDMATURINGSECURITIESBYTYPE) String estimatedAmountOfPubliclyHeldMaturingSecuritiesByType) {
        this.estimatedAmountOfPubliclyHeldMaturingSecuritiesByType = estimatedAmountOfPubliclyHeldMaturingSecuritiesByType;
    }

    private String fimaIncluded;

    /**
     * Getter method for the fimaIncluded property.
     */
    public String getFimaIncluded () {
        return fimaIncluded;
    }

    public static final String FIMAINCLUDED = "fimaIncluded";

    /**
     * Setter method for the fimaIncluded property.
     */
    public void setFimaIncluded (@Changeable(FIMAINCLUDED) String fimaIncluded) {
        this.fimaIncluded = fimaIncluded;
    }

    private String fimaNoncompetitiveAccepted;

    /**
     * Getter method for the fimaNoncompetitiveAccepted property.
     */
    public String getFimaNoncompetitiveAccepted () {
        return fimaNoncompetitiveAccepted;
    }

    public static final String FIMANONCOMPETITIVEACCEPTED = "fimaNoncompetitiveAccepted";

    /**
     * Setter method for the fimaNoncompetitiveAccepted property.
     */
    public void setFimaNoncompetitiveAccepted (@Changeable(FIMANONCOMPETITIVEACCEPTED) String fimaNoncompetitiveAccepted) {
        this.fimaNoncompetitiveAccepted = fimaNoncompetitiveAccepted;
    }

    private String fimaNoncompetitiveTendered;

    /**
     * Getter method for the fimaNoncompetitiveTendered property.
     */
    public String getFimaNoncompetitiveTendered () {
        return fimaNoncompetitiveTendered;
    }

    public static final String FIMANONCOMPETITIVETENDERED = "fimaNoncompetitiveTendered";

    /**
     * Setter method for the fimaNoncompetitiveTendered property.
     */
    public void setFimaNoncompetitiveTendered (@Changeable(FIMANONCOMPETITIVETENDERED) String fimaNoncompetitiveTendered) {
        this.fimaNoncompetitiveTendered = fimaNoncompetitiveTendered;
    }

    private String firstInterestPeriod;

    /**
     * Getter method for the firstInterestPeriod property.
     */
    public String getFirstInterestPeriod () {
        return firstInterestPeriod;
    }

    public static final String FIRSTINTERESTPERIOD = "firstInterestPeriod";

    /**
     * Setter method for the firstInterestPeriod property.
     */
    public void setFirstInterestPeriod (@Changeable(FIRSTINTERESTPERIOD) String firstInterestPeriod) {
        this.firstInterestPeriod = firstInterestPeriod;
    }

    private String firstInterestPaymentDate;

    /**
     * Getter method for the firstInterestPaymentDate property.
     */
    public String getFirstInterestPaymentDate () {
        return firstInterestPaymentDate;
    }

    public static final String FIRSTINTERESTPAYMENTDATE = "firstInterestPaymentDate";

    /**
     * Setter method for the firstInterestPaymentDate property.
     */
    public void setFirstInterestPaymentDate (@Changeable(FIRSTINTERESTPAYMENTDATE) String firstInterestPaymentDate) {
        this.firstInterestPaymentDate = firstInterestPaymentDate;
    }

    private String floatingRate;

    /**
     * Getter method for the floatingRate property.
     */
    public String getFloatingRate () {
        return floatingRate;
    }

    public static final String FLOATINGRATE = "floatingRate";

    /**
     * Setter method for the floatingRate property.
     */
    public void setFloatingRate (@Changeable(FLOATINGRATE) String floatingRate) {
        this.floatingRate = floatingRate;
    }

    private String frnIndexDeterminationDate;

    /**
     * Getter method for the frnIndexDeterminationDate property.
     */
    public String getFrnIndexDeterminationDate () {
        return frnIndexDeterminationDate;
    }

    public static final String FRNINDEXDETERMINATIONDATE = "frnIndexDeterminationDate";

    /**
     * Setter method for the frnIndexDeterminationDate property.
     */
    public void setFrnIndexDeterminationDate (@Changeable(FRNINDEXDETERMINATIONDATE) String frnIndexDeterminationDate) {
        this.frnIndexDeterminationDate = frnIndexDeterminationDate;
    }

    private String frnIndexDeterminationRate;

    /**
     * Getter method for the frnIndexDeterminationRate property.
     */
    public String getFrnIndexDeterminationRate () {
        return frnIndexDeterminationRate;
    }

    public static final String FRNINDEXDETERMINATIONRATE = "frnIndexDeterminationRate";

    /**
     * Setter method for the frnIndexDeterminationRate property.
     */
    public void setFrnIndexDeterminationRate (@Changeable(FRNINDEXDETERMINATIONRATE) String frnIndexDeterminationRate) {
        this.frnIndexDeterminationRate = frnIndexDeterminationRate;
    }

    private String highDiscountRate;

    /**
     * Getter method for the highDiscountRate property.
     */
    public String getHighDiscountRate () {
        return highDiscountRate;
    }

    public static final String HIGHDISCOUNTRATE = "highDiscountRate";

    /**
     * Setter method for the highDiscountRate property.
     */
    public void setHighDiscountRate (@Changeable(HIGHDISCOUNTRATE) String highDiscountRate) {
        this.highDiscountRate = highDiscountRate;
    }

    private String highInvestmentRate;

    /**
     * Getter method for the highInvestmentRate property.
     */
    public String getHighInvestmentRate () {
        return highInvestmentRate;
    }

    public static final String HIGHINVESTMENTRATE = "highInvestmentRate";

    /**
     * Setter method for the highInvestmentRate property.
     */
    public void setHighInvestmentRate (@Changeable(HIGHINVESTMENTRATE) String highInvestmentRate) {
        this.highInvestmentRate = highInvestmentRate;
    }

    private String highPrice;

    /**
     * Getter method for the highPrice property.
     */
    public String getHighPrice () {
        return highPrice;
    }

    public static final String HIGHPRICE = "highPrice";

    /**
     * Setter method for the highPrice property.
     */
    public void setHighPrice (@Changeable(HIGHPRICE) String highPrice) {
        this.highPrice = highPrice;
    }

    private String highDiscountMargin;

    /**
     * Getter method for the highDiscountMargin property.
     */
    public String getHighDiscountMargin () {
        return highDiscountMargin;
    }

    public static final String HIGHDISCOUNTMARGIN = "highDiscountMargin";

    /**
     * Setter method for the highDiscountMargin property.
     */
    public void setHighDiscountMargin (@Changeable(HIGHDISCOUNTMARGIN) String highDiscountMargin) {
        this.highDiscountMargin = highDiscountMargin;
    }

    private String highYield;

    /**
     * Getter method for the highYield property.
     */
    public String getHighYield () {
        return highYield;
    }

    public static final String HIGHYIELD = "highYield";

    /**
     * Setter method for the highYield property.
     */
    public void setHighYield (@Changeable(HIGHYIELD) String highYield) {
        this.highYield = highYield;
    }

    private String indexRatioOnIssueDate;

    /**
     * Getter method for the indexRatioOnIssueDate property.
     */
    public String getIndexRatioOnIssueDate () {
        return indexRatioOnIssueDate;
    }

    public static final String INDEXRATIOONISSUEDATE = "indexRatioOnIssueDate";

    /**
     * Setter method for the indexRatioOnIssueDate property.
     */
    public void setIndexRatioOnIssueDate (@Changeable(INDEXRATIOONISSUEDATE) String indexRatioOnIssueDate) {
        this.indexRatioOnIssueDate = indexRatioOnIssueDate;
    }

    private String indirectBidderAccepted;

    /**
     * Getter method for the indirectBidderAccepted property.
     */
    public String getIndirectBidderAccepted () {
        return indirectBidderAccepted;
    }

    public static final String INDIRECTBIDDERACCEPTED = "indirectBidderAccepted";

    /**
     * Setter method for the indirectBidderAccepted property.
     */
    public void setIndirectBidderAccepted (@Changeable(INDIRECTBIDDERACCEPTED) String indirectBidderAccepted) {
        this.indirectBidderAccepted = indirectBidderAccepted;
    }

    private String indirectBidderTendered;

    /**
     * Getter method for the indirectBidderTendered property.
     */
    public String getIndirectBidderTendered () {
        return indirectBidderTendered;
    }

    public static final String INDIRECTBIDDERTENDERED = "indirectBidderTendered";

    /**
     * Setter method for the indirectBidderTendered property.
     */
    public void setIndirectBidderTendered (@Changeable(INDIRECTBIDDERTENDERED) String indirectBidderTendered) {
        this.indirectBidderTendered = indirectBidderTendered;
    }

    private String interestPaymentFrequency;

    /**
     * Getter method for the interestPaymentFrequency property.
     */
    public String getInterestPaymentFrequency () {
        return interestPaymentFrequency;
    }

    public static final String INTERESTPAYMENTFREQUENCY = "interestPaymentFrequency";

    /**
     * Setter method for the interestPaymentFrequency property.
     */
    public void setInterestPaymentFrequency (@Changeable(INTERESTPAYMENTFREQUENCY) String interestPaymentFrequency) {
        this.interestPaymentFrequency = interestPaymentFrequency;
    }

    private String lowDiscountRate;

    /**
     * Getter method for the lowDiscountRate property.
     */
    public String getLowDiscountRate () {
        return lowDiscountRate;
    }

    public static final String LOWDISCOUNTRATE = "lowDiscountRate";

    /**
     * Setter method for the lowDiscountRate property.
     */
    public void setLowDiscountRate (@Changeable(LOWDISCOUNTRATE) String lowDiscountRate) {
        this.lowDiscountRate = lowDiscountRate;
    }

    private String lowInvestmentRate;

    /**
     * Getter method for the lowInvestmentRate property.
     */
    public String getLowInvestmentRate () {
        return lowInvestmentRate;
    }

    public static final String LOWINVESTMENTRATE = "lowInvestmentRate";

    /**
     * Setter method for the lowInvestmentRate property.
     */
    public void setLowInvestmentRate (@Changeable(LOWINVESTMENTRATE) String lowInvestmentRate) {
        this.lowInvestmentRate = lowInvestmentRate;
    }

    private String lowPrice;

    /**
     * Getter method for the lowPrice property.
     */
    public String getLowPrice () {
        return lowPrice;
    }

    public static final String LOWPRICE = "lowPrice";

    /**
     * Setter method for the lowPrice property.
     */
    public void setLowPrice (@Changeable(LOWPRICE) String lowPrice) {
        this.lowPrice = lowPrice;
    }

    private String lowDiscountMargin;

    /**
     * Getter method for the lowDiscountMargin property.
     */
    public String getLowDiscountMargin () {
        return lowDiscountMargin;
    }

    public static final String LOWDISCOUNTMARGIN = "lowDiscountMargin";

    /**
     * Setter method for the lowDiscountMargin property.
     */
    public void setLowDiscountMargin (@Changeable(LOWDISCOUNTMARGIN) String lowDiscountMargin) {
        this.lowDiscountMargin = lowDiscountMargin;
    }

    private String lowYield;

    /**
     * Getter method for the lowYield property.
     */
    public String getLowYield () {
        return lowYield;
    }

    public static final String LOWYIELD = "lowYield";

    /**
     * Setter method for the lowYield property.
     */
    public void setLowYield (@Changeable(LOWYIELD) String lowYield) {
        this.lowYield = lowYield;
    }

    private String maturingDate;

    /**
     * Getter method for the maturingDate property.
     */
    public String getMaturingDate () {
        return maturingDate;
    }

    public static final String MATURINGDATE = "maturingDate";

    /**
     * Setter method for the maturingDate property.
     */
    public void setMaturingDate (@Changeable(MATURINGDATE) String maturingDate) {
        this.maturingDate = maturingDate;
    }

    private String maximumCompetitiveAward;

    /**
     * Getter method for the maximumCompetitiveAward property.
     */
    public String getMaximumCompetitiveAward () {
        return maximumCompetitiveAward;
    }

    public static final String MAXIMUMCOMPETITIVEAWARD = "maximumCompetitiveAward";

    /**
     * Setter method for the maximumCompetitiveAward property.
     */
    public void setMaximumCompetitiveAward (@Changeable(MAXIMUMCOMPETITIVEAWARD) String maximumCompetitiveAward) {
        this.maximumCompetitiveAward = maximumCompetitiveAward;
    }

    private String maximumNoncompetitiveAward;

    /**
     * Getter method for the maximumNoncompetitiveAward property.
     */
    public String getMaximumNoncompetitiveAward () {
        return maximumNoncompetitiveAward;
    }

    public static final String MAXIMUMNONCOMPETITIVEAWARD = "maximumNoncompetitiveAward";

    /**
     * Setter method for the maximumNoncompetitiveAward property.
     */
    public void setMaximumNoncompetitiveAward (@Changeable(MAXIMUMNONCOMPETITIVEAWARD) String maximumNoncompetitiveAward) {
        this.maximumNoncompetitiveAward = maximumNoncompetitiveAward;
    }

    private String maximumSingleBid;

    /**
     * Getter method for the maximumSingleBid property.
     */
    public String getMaximumSingleBid () {
        return maximumSingleBid;
    }

    public static final String MAXIMUMSINGLEBID = "maximumSingleBid";

    /**
     * Setter method for the maximumSingleBid property.
     */
    public void setMaximumSingleBid (@Changeable(MAXIMUMSINGLEBID) String maximumSingleBid) {
        this.maximumSingleBid = maximumSingleBid;
    }

    private String minimumBidAmount;

    /**
     * Getter method for the minimumBidAmount property.
     */
    public String getMinimumBidAmount () {
        return minimumBidAmount;
    }

    public static final String MINIMUMBIDAMOUNT = "minimumBidAmount";

    /**
     * Setter method for the minimumBidAmount property.
     */
    public void setMinimumBidAmount (@Changeable(MINIMUMBIDAMOUNT) String minimumBidAmount) {
        this.minimumBidAmount = minimumBidAmount;
    }

    private String minimumStripAmount;

    /**
     * Getter method for the minimumStripAmount property.
     */
    public String getMinimumStripAmount () {
        return minimumStripAmount;
    }

    public static final String MINIMUMSTRIPAMOUNT = "minimumStripAmount";

    /**
     * Setter method for the minimumStripAmount property.
     */
    public void setMinimumStripAmount (@Changeable(MINIMUMSTRIPAMOUNT) String minimumStripAmount) {
        this.minimumStripAmount = minimumStripAmount;
    }

    private String minimumToIssue;

    /**
     * Getter method for the minimumToIssue property.
     */
    public String getMinimumToIssue () {
        return minimumToIssue;
    }

    public static final String MINIMUMTOISSUE = "minimumToIssue";

    /**
     * Setter method for the minimumToIssue property.
     */
    public void setMinimumToIssue (@Changeable(MINIMUMTOISSUE) String minimumToIssue) {
        this.minimumToIssue = minimumToIssue;
    }

    private String multiplesToBid;

    /**
     * Getter method for the multiplesToBid property.
     */
    public String getMultiplesToBid () {
        return multiplesToBid;
    }

    public static final String MULTIPLESTOBID = "multiplesToBid";

    /**
     * Setter method for the multiplesToBid property.
     */
    public void setMultiplesToBid (@Changeable(MULTIPLESTOBID) String multiplesToBid) {
        this.multiplesToBid = multiplesToBid;
    }

    private String multiplesToIssue;

    /**
     * Getter method for the multiplesToIssue property.
     */
    public String getMultiplesToIssue () {
        return multiplesToIssue;
    }

    public static final String MULTIPLESTOISSUE = "multiplesToIssue";

    /**
     * Setter method for the multiplesToIssue property.
     */
    public void setMultiplesToIssue (@Changeable(MULTIPLESTOISSUE) String multiplesToIssue) {
        this.multiplesToIssue = multiplesToIssue;
    }

    private String nlpExclusionAmount;

    /**
     * Getter method for the nlpExclusionAmount property.
     */
    public String getNlpExclusionAmount () {
        return nlpExclusionAmount;
    }

    public static final String NLPEXCLUSIONAMOUNT = "nlpExclusionAmount";

    /**
     * Setter method for the nlpExclusionAmount property.
     */
    public void setNlpExclusionAmount (@Changeable(NLPEXCLUSIONAMOUNT) String nlpExclusionAmount) {
        this.nlpExclusionAmount = nlpExclusionAmount;
    }

    private String nlpReportingThreshold;

    /**
     * Getter method for the nlpReportingThreshold property.
     */
    public String getNlpReportingThreshold () {
        return nlpReportingThreshold;
    }

    public static final String NLPREPORTINGTHRESHOLD = "nlpReportingThreshold";

    /**
     * Setter method for the nlpReportingThreshold property.
     */
    public void setNlpReportingThreshold (@Changeable(NLPREPORTINGTHRESHOLD) String nlpReportingThreshold) {
        this.nlpReportingThreshold = nlpReportingThreshold;
    }

    private String noncompetitiveAccepted;

    /**
     * Getter method for the noncompetitiveAccepted property.
     */
    public String getNoncompetitiveAccepted () {
        return noncompetitiveAccepted;
    }

    public static final String NONCOMPETITIVEACCEPTED = "noncompetitiveAccepted";

    /**
     * Setter method for the noncompetitiveAccepted property.
     */
    public void setNoncompetitiveAccepted (@Changeable(NONCOMPETITIVEACCEPTED) String noncompetitiveAccepted) {
        this.noncompetitiveAccepted = noncompetitiveAccepted;
    }

    private String noncompetitiveTendersAccepted;

    /**
     * Getter method for the noncompetitiveTendersAccepted property.
     */
    public String getNoncompetitiveTendersAccepted () {
        return noncompetitiveTendersAccepted;
    }

    public static final String NONCOMPETITIVETENDERSACCEPTED = "noncompetitiveTendersAccepted";

    /**
     * Setter method for the noncompetitiveTendersAccepted property.
     */
    public void setNoncompetitiveTendersAccepted (@Changeable(NONCOMPETITIVETENDERSACCEPTED) String noncompetitiveTendersAccepted) {
        this.noncompetitiveTendersAccepted = noncompetitiveTendersAccepted;
    }

    private String offeringAmount;

    /**
     * Getter method for the offeringAmount property.
     */
    public String getOfferingAmount () {
        return offeringAmount;
    }

    public static final String OFFERINGAMOUNT = "offeringAmount";

    /**
     * Setter method for the offeringAmount property.
     */
    public void setOfferingAmount (@Changeable(OFFERINGAMOUNT) String offeringAmount) {
        this.offeringAmount = offeringAmount;
    }

    private String originalCusip;

    /**
     * Getter method for the originalCusip property.
     */
    public String getOriginalCusip () {
        return originalCusip;
    }

    public static final String ORIGINALCUSIP = "originalCusip";

    /**
     * Setter method for the originalCusip property.
     */
    public void setOriginalCusip (@Changeable(ORIGINALCUSIP) String originalCusip) {
        this.originalCusip = originalCusip;
    }

    private String originalDatedDate;

    /**
     * Getter method for the originalDatedDate property.
     */
    public String getOriginalDatedDate () {
        return originalDatedDate;
    }

    public static final String ORIGINALDATEDDATE = "originalDatedDate";

    /**
     * Setter method for the originalDatedDate property.
     */
    public void setOriginalDatedDate (@Changeable(ORIGINALDATEDDATE) String originalDatedDate) {
        this.originalDatedDate = originalDatedDate;
    }

    private String originalIssueDate;

    /**
     * Getter method for the originalIssueDate property.
     */
    public String getOriginalIssueDate () {
        return originalIssueDate;
    }

    public static final String ORIGINALISSUEDATE = "originalIssueDate";

    /**
     * Setter method for the originalIssueDate property.
     */
    public void setOriginalIssueDate (@Changeable(ORIGINALISSUEDATE) String originalIssueDate) {
        this.originalIssueDate = originalIssueDate;
    }

    private String originalSecurityTerm;

    /**
     * Getter method for the originalSecurityTerm property.
     */
    public String getOriginalSecurityTerm () {
        return originalSecurityTerm;
    }

    public static final String ORIGINALSECURITYTERM = "originalSecurityTerm";

    /**
     * Setter method for the originalSecurityTerm property.
     */
    public void setOriginalSecurityTerm (@Changeable(ORIGINALSECURITYTERM) String originalSecurityTerm) {
        this.originalSecurityTerm = originalSecurityTerm;
    }

    private String pdfFilenameAnnouncement;

    /**
     * Getter method for the pdfFilenameAnnouncement property.
     */
    public String getPdfFilenameAnnouncement () {
        return pdfFilenameAnnouncement;
    }

    public static final String PDFFILENAMEANNOUNCEMENT = "pdfFilenameAnnouncement";

    /**
     * Setter method for the pdfFilenameAnnouncement property.
     */
    public void setPdfFilenameAnnouncement (@Changeable(PDFFILENAMEANNOUNCEMENT) String pdfFilenameAnnouncement) {
        this.pdfFilenameAnnouncement = pdfFilenameAnnouncement;
    }

    private String pdfFilenameCompetitiveResults;

    /**
     * Getter method for the pdfFilenameCompetitiveResults property.
     */
    public String getPdfFilenameCompetitiveResults () {
        return pdfFilenameCompetitiveResults;
    }

    public static final String PDFFILENAMECOMPETITIVERESULTS = "pdfFilenameCompetitiveResults";

    /**
     * Setter method for the pdfFilenameCompetitiveResults property.
     */
    public void setPdfFilenameCompetitiveResults (@Changeable(PDFFILENAMECOMPETITIVERESULTS) String pdfFilenameCompetitiveResults) {
        this.pdfFilenameCompetitiveResults = pdfFilenameCompetitiveResults;
    }

    private String pdfFilenameNoncompetitiveResults;

    /**
     * Getter method for the pdfFilenameNoncompetitiveResults property.
     */
    public String getPdfFilenameNoncompetitiveResults () {
        return pdfFilenameNoncompetitiveResults;
    }

    public static final String PDFFILENAMENONCOMPETITIVERESULTS = "pdfFilenameNoncompetitiveResults";

    /**
     * Setter method for the pdfFilenameNoncompetitiveResults property.
     */
    public void setPdfFilenameNoncompetitiveResults (@Changeable(PDFFILENAMENONCOMPETITIVERESULTS) String pdfFilenameNoncompetitiveResults) {
        this.pdfFilenameNoncompetitiveResults = pdfFilenameNoncompetitiveResults;
    }

    private String pdfFilenameSpecialAnnouncement;

    /**
     * Getter method for the pdfFilenameSpecialAnnouncement property.
     */
    public String getPdfFilenameSpecialAnnouncement () {
        return pdfFilenameSpecialAnnouncement;
    }

    public static final String PDFFILENAMESPECIALANNOUNCEMENT = "pdfFilenameSpecialAnnouncement";

    /**
     * Setter method for the pdfFilenameSpecialAnnouncement property.
     */
    public void setPdfFilenameSpecialAnnouncement (@Changeable(PDFFILENAMESPECIALANNOUNCEMENT) String pdfFilenameSpecialAnnouncement) {
        this.pdfFilenameSpecialAnnouncement = pdfFilenameSpecialAnnouncement;
    }

    private String pricePer100;

    /**
     * Getter method for the pricePer100 property.
     */
    public String getPricePer100 () {
        return pricePer100;
    }

    public static final String PRICEPER100 = "pricePer100";

    /**
     * Setter method for the pricePer100 property.
     */
    public void setPricePer100 (@Changeable(PRICEPER100) String pricePer100) {
        this.pricePer100 = pricePer100;
    }

    private String primaryDealerAccepted;

    /**
     * Getter method for the primaryDealerAccepted property.
     */
    public String getPrimaryDealerAccepted () {
        return primaryDealerAccepted;
    }

    public static final String PRIMARYDEALERACCEPTED = "primaryDealerAccepted";

    /**
     * Setter method for the primaryDealerAccepted property.
     */
    public void setPrimaryDealerAccepted (@Changeable(PRIMARYDEALERACCEPTED) String primaryDealerAccepted) {
        this.primaryDealerAccepted = primaryDealerAccepted;
    }

    private String primaryDealerTendered;

    /**
     * Getter method for the primaryDealerTendered property.
     */
    public String getPrimaryDealerTendered () {
        return primaryDealerTendered;
    }

    public static final String PRIMARYDEALERTENDERED = "primaryDealerTendered";

    /**
     * Setter method for the primaryDealerTendered property.
     */
    public void setPrimaryDealerTendered (@Changeable(PRIMARYDEALERTENDERED) String primaryDealerTendered) {
        this.primaryDealerTendered = primaryDealerTendered;
    }

    private String reopening;

    /**
     * Getter method for the reopening property.
     */
    public String getReopening () {
        return reopening;
    }

    public static final String REOPENING = "reopening";

    /**
     * Setter method for the reopening property.
     */
    public void setReopening (@Changeable(REOPENING) String reopening) {
        this.reopening = reopening;
    }

    private String securityTermDayMonth;

    /**
     * Getter method for the securityTermDayMonth property.
     */
    public String getSecurityTermDayMonth () {
        return securityTermDayMonth;
    }

    public static final String SECURITYTERMDAYMONTH = "securityTermDayMonth";

    /**
     * Setter method for the securityTermDayMonth property.
     */
    public void setSecurityTermDayMonth (@Changeable(SECURITYTERMDAYMONTH) String securityTermDayMonth) {
        this.securityTermDayMonth = securityTermDayMonth;
    }

    private String securityTermWeekYear;

    /**
     * Getter method for the securityTermWeekYear property.
     */
    public String getSecurityTermWeekYear () {
        return securityTermWeekYear;
    }

    public static final String SECURITYTERMWEEKYEAR = "securityTermWeekYear";

    /**
     * Setter method for the securityTermWeekYear property.
     */
    public void setSecurityTermWeekYear (@Changeable(SECURITYTERMWEEKYEAR) String securityTermWeekYear) {
        this.securityTermWeekYear = securityTermWeekYear;
    }

    private String series;

    /**
     * Getter method for the series property.
     */
    public String getSeries () {
        return series;
    }

    public static final String SERIES = "series";

    /**
     * Setter method for the series property.
     */
    public void setSeries (@Changeable(SERIES) String series) {
        this.series = series;
    }

    private String somaAccepted;

    /**
     * Getter method for the somaAccepted property.
     */
    public String getSomaAccepted () {
        return somaAccepted;
    }

    public static final String SOMAACCEPTED = "somaAccepted";

    /**
     * Setter method for the somaAccepted property.
     */
    public void setSomaAccepted (@Changeable(SOMAACCEPTED) String somaAccepted) {
        this.somaAccepted = somaAccepted;
    }

    private String somaHoldings;

    /**
     * Getter method for the somaHoldings property.
     */
    public String getSomaHoldings () {
        return somaHoldings;
    }

    public static final String SOMAHOLDINGS = "somaHoldings";

    /**
     * Setter method for the somaHoldings property.
     */
    public void setSomaHoldings (@Changeable(SOMAHOLDINGS) String somaHoldings) {
        this.somaHoldings = somaHoldings;
    }

    private String somaIncluded;

    /**
     * Getter method for the somaIncluded property.
     */
    public String getSomaIncluded () {
        return somaIncluded;
    }

    public static final String SOMAINCLUDED = "somaIncluded";

    /**
     * Setter method for the somaIncluded property.
     */
    public void setSomaIncluded (@Changeable(SOMAINCLUDED) String somaIncluded) {
        this.somaIncluded = somaIncluded;
    }

    private String somaTendered;

    /**
     * Getter method for the somaTendered property.
     */
    public String getSomaTendered () {
        return somaTendered;
    }

    public static final String SOMATENDERED = "somaTendered";

    /**
     * Setter method for the somaTendered property.
     */
    public void setSomaTendered (@Changeable(SOMATENDERED) String somaTendered) {
        this.somaTendered = somaTendered;
    }

    private String spread;

    /**
     * Getter method for the spread property.
     */
    public String getSpread () {
        return spread;
    }

    public static final String SPREAD = "spread";

    /**
     * Setter method for the spread property.
     */
    public void setSpread (@Changeable(SPREAD) String spread) {
        this.spread = spread;
    }

    private String standardInterestPaymentPer1000;

    /**
     * Getter method for the standardInterestPaymentPer1000 property.
     */
    public String getStandardInterestPaymentPer1000 () {
        return standardInterestPaymentPer1000;
    }

    public static final String STANDARDINTERESTPAYMENTPER1000 = "standardInterestPaymentPer1000";

    /**
     * Setter method for the standardInterestPaymentPer1000 property.
     */
    public void setStandardInterestPaymentPer1000 (@Changeable(STANDARDINTERESTPAYMENTPER1000) String standardInterestPaymentPer1000) {
        this.standardInterestPaymentPer1000 = standardInterestPaymentPer1000;
    }

    private String strippable;

    /**
     * Getter method for the strippable property.
     */
    public String getStrippable () {
        return strippable;
    }

    public static final String STRIPPABLE = "strippable";

    /**
     * Setter method for the strippable property.
     */
    public void setStrippable (@Changeable(STRIPPABLE) String strippable) {
        this.strippable = strippable;
    }

    private String term;

    /**
     * Getter method for the term property.
     */
    public String getTerm () {
        return term;
    }

    public static final String TERM = "term";

    /**
     * Setter method for the term property.
     */
    public void setTerm (@Changeable(TERM) String term) {
        this.term = term;
    }

    private String tiinConversionFactorPer1000;

    /**
     * Getter method for the tiinConversionFactorPer1000 property.
     */
    public String getTiinConversionFactorPer1000 () {
        return tiinConversionFactorPer1000;
    }

    public static final String TIINCONVERSIONFACTORPER1000 = "tiinConversionFactorPer1000";

    /**
     * Setter method for the tiinConversionFactorPer1000 property.
     */
    public void setTiinConversionFactorPer1000 (@Changeable(TIINCONVERSIONFACTORPER1000) String tiinConversionFactorPer1000) {
        this.tiinConversionFactorPer1000 = tiinConversionFactorPer1000;
    }

    private String tips;

    /**
     * Getter method for the tips property.
     */
    public String getTips () {
        return tips;
    }

    public static final String TIPS = "tips";

    /**
     * Setter method for the tips property.
     */
    public void setTips (@Changeable(TIPS) String tips) {
        this.tips = tips;
    }

    private String totalAccepted;

    /**
     * Getter method for the totalAccepted property.
     */
    public String getTotalAccepted () {
        return totalAccepted;
    }

    public static final String TOTALACCEPTED = "totalAccepted";

    /**
     * Setter method for the totalAccepted property.
     */
    public void setTotalAccepted (@Changeable(TOTALACCEPTED) String totalAccepted) {
        this.totalAccepted = totalAccepted;
    }

    private String totalTendered;

    /**
     * Getter method for the totalTendered property.
     */
    public String getTotalTendered () {
        return totalTendered;
    }

    public static final String TOTALTENDERED = "totalTendered";

    /**
     * Setter method for the totalTendered property.
     */
    public void setTotalTendered (@Changeable(TOTALTENDERED) String totalTendered) {
        this.totalTendered = totalTendered;
    }

    private String treasuryDirectAccepted;

    /**
     * Getter method for the treasuryDirectAccepted property.
     */
    public String getTreasuryDirectAccepted () {
        return treasuryDirectAccepted;
    }

    public static final String TREASURYDIRECTACCEPTED = "treasuryDirectAccepted";

    /**
     * Setter method for the treasuryDirectAccepted property.
     */
    public void setTreasuryDirectAccepted (@Changeable(TREASURYDIRECTACCEPTED) String treasuryDirectAccepted) {
        this.treasuryDirectAccepted = treasuryDirectAccepted;
    }

    private String treasuryDirectTendersAccepted;

    /**
     * Getter method for the treasuryDirectTendersAccepted property.
     */
    public String getTreasuryDirectTendersAccepted () {
        return treasuryDirectTendersAccepted;
    }

    public static final String TREASURYDIRECTTENDERSACCEPTED = "treasuryDirectTendersAccepted";

    /**
     * Setter method for the treasuryDirectTendersAccepted property.
     */
    public void setTreasuryDirectTendersAccepted (@Changeable(TREASURYDIRECTTENDERSACCEPTED) String treasuryDirectTendersAccepted) {
        this.treasuryDirectTendersAccepted = treasuryDirectTendersAccepted;
    }

    private String type;

    /**
     * Getter method for the type property.
     */
    public String getType () {
        return type;
    }

    public static final String TYPE = "type";

    /**
     * Setter method for the type property.
     */
    public void setType (@Changeable(TYPE) String type) {
        this.type = type;
    }

    private String unadjustedAccruedInterestPer1000;

    /**
     * Getter method for the unadjustedAccruedInterestPer1000 property.
     */
    public String getUnadjustedAccruedInterestPer1000 () {
        return unadjustedAccruedInterestPer1000;
    }

    public static final String UNADJUSTEDACCRUEDINTERESTPER1000 = "unadjustedAccruedInterestPer1000";

    /**
     * Setter method for the unadjustedAccruedInterestPer1000 property.
     */
    public void setUnadjustedAccruedInterestPer1000 (@Changeable(UNADJUSTEDACCRUEDINTERESTPER1000) String unadjustedAccruedInterestPer1000) {
        this.unadjustedAccruedInterestPer1000 = unadjustedAccruedInterestPer1000;
    }

    private String unadjustedPrice;

    /**
     * Getter method for the unadjustedPrice property.
     */
    public String getUnadjustedPrice () {
        return unadjustedPrice;
    }

    public static final String UNADJUSTEDPRICE = "unadjustedPrice";

    /**
     * Setter method for the unadjustedPrice property.
     */
    public void setUnadjustedPrice (@Changeable(UNADJUSTEDPRICE) String unadjustedPrice) {
        this.unadjustedPrice = unadjustedPrice;
    }

    private String updatedTimestamp;

    /**
     * Getter method for the updatedTimestamp property.
     */
    public String getUpdatedTimestamp () {
        return updatedTimestamp;
    }

    public static final String UPDATEDTIMESTAMP = "updatedTimestamp";

    /**
     * Setter method for the updatedTimestamp property.
     */
    public void setUpdatedTimestamp (@Changeable(UPDATEDTIMESTAMP) String updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }

    private String xmlFilenameAnnouncement;

    /**
     * Getter method for the xmlFilenameAnnouncement property.
     */
    public String getXmlFilenameAnnouncement () {
        return xmlFilenameAnnouncement;
    }

    public static final String XMLFILENAMEANNOUNCEMENT = "xmlFilenameAnnouncement";

    /**
     * Setter method for the xmlFilenameAnnouncement property.
     */
    public void setXmlFilenameAnnouncement (@Changeable(XMLFILENAMEANNOUNCEMENT) String xmlFilenameAnnouncement) {
        this.xmlFilenameAnnouncement = xmlFilenameAnnouncement;
    }

    private String xmlFilenameCompetitiveResults;

    /**
     * Getter method for the xmlFilenameCompetitiveResults property.
     */
    public String getXmlFilenameCompetitiveResults () {
        return xmlFilenameCompetitiveResults;
    }

    public static final String XMLFILENAMECOMPETITIVERESULTS = "xmlFilenameCompetitiveResults";

    /**
     * Setter method for the xmlFilenameCompetitiveResults property.
     */
    public void setXmlFilenameCompetitiveResults (@Changeable(XMLFILENAMECOMPETITIVERESULTS) String xmlFilenameCompetitiveResults) {
        this.xmlFilenameCompetitiveResults = xmlFilenameCompetitiveResults;
    }

    private String xmlFilenameSpecialAnnouncement;

    /**
     * Getter method for the xmlFilenameSpecialAnnouncement property.
     */
    public String getXmlFilenameSpecialAnnouncement () {
        return xmlFilenameSpecialAnnouncement;
    }

    public static final String XMLFILENAMESPECIALANNOUNCEMENT = "xmlFilenameSpecialAnnouncement";

    /**
     * Setter method for the xmlFilenameSpecialAnnouncement property.
     */
    public void setXmlFilenameSpecialAnnouncement (@Changeable(XMLFILENAMESPECIALANNOUNCEMENT) String xmlFilenameSpecialAnnouncement) {
        this.xmlFilenameSpecialAnnouncement = xmlFilenameSpecialAnnouncement;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((accruedInterestPer100 == null) ? 0 : accruedInterestPer100.hashCode());
        result = prime * result + ((accruedInterestPer1000 == null) ? 0 : accruedInterestPer1000.hashCode());
        result = prime * result
                + ((adjustedAccruedInterestPer1000 == null) ? 0 : adjustedAccruedInterestPer1000.hashCode());
        result = prime * result + ((adjustedPrice == null) ? 0 : adjustedPrice.hashCode());
        result = prime * result + ((allocationPercentage == null) ? 0 : allocationPercentage.hashCode());
        result = prime * result
                + ((allocationPercentageDecimals == null) ? 0 : allocationPercentageDecimals.hashCode());
        result = prime * result + ((announcedCusip == null) ? 0 : announcedCusip.hashCode());
        result = prime * result + ((announcementDate == null) ? 0 : announcementDate.hashCode());
        result = prime * result + ((auctionDate == null) ? 0 : auctionDate.hashCode());
        result = prime * result + ((auctionDateYear == null) ? 0 : auctionDateYear.hashCode());
        result = prime * result + ((auctionFormat == null) ? 0 : auctionFormat.hashCode());
        result = prime * result + ((averageMedianDiscountMargin == null) ? 0 : averageMedianDiscountMargin.hashCode());
        result = prime * result + ((averageMedianDiscountRate == null) ? 0 : averageMedianDiscountRate.hashCode());
        result = prime * result + ((averageMedianInvestmentRate == null) ? 0 : averageMedianInvestmentRate.hashCode());
        result = prime * result + ((averageMedianPrice == null) ? 0 : averageMedianPrice.hashCode());
        result = prime * result + ((averageMedianYield == null) ? 0 : averageMedianYield.hashCode());
        result = prime * result + ((backDated == null) ? 0 : backDated.hashCode());
        result = prime * result + ((backDatedDate == null) ? 0 : backDatedDate.hashCode());
        result = prime * result + ((bidToCoverRatio == null) ? 0 : bidToCoverRatio.hashCode());
        result = prime * result + ((callDate == null) ? 0 : callDate.hashCode());
        result = prime * result + ((callable == null) ? 0 : callable.hashCode());
        result = prime * result + ((calledDate == null) ? 0 : calledDate.hashCode());
        result = prime * result + ((cashManagementBillCMB == null) ? 0 : cashManagementBillCMB.hashCode());
        result = prime * result + ((closingTimeCompetitive == null) ? 0 : closingTimeCompetitive.hashCode());
        result = prime * result + ((closingTimeNoncompetitive == null) ? 0 : closingTimeNoncompetitive.hashCode());
        result = prime * result + ((competitiveAccepted == null) ? 0 : competitiveAccepted.hashCode());
        result = prime * result + ((competitiveBidDecimals == null) ? 0 : competitiveBidDecimals.hashCode());
        result = prime * result + ((competitiveTendered == null) ? 0 : competitiveTendered.hashCode());
        result = prime * result + ((competitiveTendersAccepted == null) ? 0 : competitiveTendersAccepted.hashCode());
        result = prime * result + ((corpusCusip == null) ? 0 : corpusCusip.hashCode());
        result = prime * result + ((cpiBaseReferencePeriod == null) ? 0 : cpiBaseReferencePeriod.hashCode());
        result = prime * result + ((currentlyOutstanding == null) ? 0 : currentlyOutstanding.hashCode());
        result = prime * result + ((cusip == null) ? 0 : cusip.hashCode());
        result = prime * result + ((datedDate == null) ? 0 : datedDate.hashCode());
        result = prime * result + ((directBidderAccepted == null) ? 0 : directBidderAccepted.hashCode());
        result = prime * result + ((directBidderTendered == null) ? 0 : directBidderTendered.hashCode());
        result = prime * result + ((estimatedAmountOfPubliclyHeldMaturingSecuritiesByType == null) ? 0
                : estimatedAmountOfPubliclyHeldMaturingSecuritiesByType.hashCode());
        result = prime * result + ((fimaIncluded == null) ? 0 : fimaIncluded.hashCode());
        result = prime * result + ((fimaNoncompetitiveAccepted == null) ? 0 : fimaNoncompetitiveAccepted.hashCode());
        result = prime * result + ((fimaNoncompetitiveTendered == null) ? 0 : fimaNoncompetitiveTendered.hashCode());
        result = prime * result + ((firstInterestPaymentDate == null) ? 0 : firstInterestPaymentDate.hashCode());
        result = prime * result + ((firstInterestPeriod == null) ? 0 : firstInterestPeriod.hashCode());
        result = prime * result + ((floatingRate == null) ? 0 : floatingRate.hashCode());
        result = prime * result + ((frnIndexDeterminationDate == null) ? 0 : frnIndexDeterminationDate.hashCode());
        result = prime * result + ((frnIndexDeterminationRate == null) ? 0 : frnIndexDeterminationRate.hashCode());
        result = prime * result + ((highDiscountMargin == null) ? 0 : highDiscountMargin.hashCode());
        result = prime * result + ((highDiscountRate == null) ? 0 : highDiscountRate.hashCode());
        result = prime * result + ((highInvestmentRate == null) ? 0 : highInvestmentRate.hashCode());
        result = prime * result + ((highPrice == null) ? 0 : highPrice.hashCode());
        result = prime * result + ((highYield == null) ? 0 : highYield.hashCode());
        result = prime * result + ((indexRatioOnIssueDate == null) ? 0 : indexRatioOnIssueDate.hashCode());
        result = prime * result + ((indirectBidderAccepted == null) ? 0 : indirectBidderAccepted.hashCode());
        result = prime * result + ((indirectBidderTendered == null) ? 0 : indirectBidderTendered.hashCode());
        result = prime * result + ((interestPaymentFrequency == null) ? 0 : interestPaymentFrequency.hashCode());
        result = prime * result + ((interestRate == null) ? 0 : interestRate.hashCode());
        result = prime * result + ((issueDate == null) ? 0 : issueDate.hashCode());
        result = prime * result + ((lowDiscountMargin == null) ? 0 : lowDiscountMargin.hashCode());
        result = prime * result + ((lowDiscountRate == null) ? 0 : lowDiscountRate.hashCode());
        result = prime * result + ((lowInvestmentRate == null) ? 0 : lowInvestmentRate.hashCode());
        result = prime * result + ((lowPrice == null) ? 0 : lowPrice.hashCode());
        result = prime * result + ((lowYield == null) ? 0 : lowYield.hashCode());
        result = prime * result + ((maturingDate == null) ? 0 : maturingDate.hashCode());
        result = prime * result + ((maturityDate == null) ? 0 : maturityDate.hashCode());
        result = prime * result + ((maximumCompetitiveAward == null) ? 0 : maximumCompetitiveAward.hashCode());
        result = prime * result + ((maximumNoncompetitiveAward == null) ? 0 : maximumNoncompetitiveAward.hashCode());
        result = prime * result + ((maximumSingleBid == null) ? 0 : maximumSingleBid.hashCode());
        result = prime * result + ((minimumBidAmount == null) ? 0 : minimumBidAmount.hashCode());
        result = prime * result + ((minimumStripAmount == null) ? 0 : minimumStripAmount.hashCode());
        result = prime * result + ((minimumToIssue == null) ? 0 : minimumToIssue.hashCode());
        result = prime * result + ((multiplesToBid == null) ? 0 : multiplesToBid.hashCode());
        result = prime * result + ((multiplesToIssue == null) ? 0 : multiplesToIssue.hashCode());
        result = prime * result + ((nlpExclusionAmount == null) ? 0 : nlpExclusionAmount.hashCode());
        result = prime * result + ((nlpReportingThreshold == null) ? 0 : nlpReportingThreshold.hashCode());
        result = prime * result + ((noncompetitiveAccepted == null) ? 0 : noncompetitiveAccepted.hashCode());
        result = prime * result
                + ((noncompetitiveTendersAccepted == null) ? 0 : noncompetitiveTendersAccepted.hashCode());
        result = prime * result + ((offeringAmount == null) ? 0 : offeringAmount.hashCode());
        result = prime * result + ((originalCusip == null) ? 0 : originalCusip.hashCode());
        result = prime * result + ((originalDatedDate == null) ? 0 : originalDatedDate.hashCode());
        result = prime * result + ((originalIssueDate == null) ? 0 : originalIssueDate.hashCode());
        result = prime * result + ((originalSecurityTerm == null) ? 0 : originalSecurityTerm.hashCode());
        result = prime * result + ((pdfFilenameAnnouncement == null) ? 0 : pdfFilenameAnnouncement.hashCode());
        result = prime * result
                + ((pdfFilenameCompetitiveResults == null) ? 0 : pdfFilenameCompetitiveResults.hashCode());
        result = prime * result
                + ((pdfFilenameNoncompetitiveResults == null) ? 0 : pdfFilenameNoncompetitiveResults.hashCode());
        result = prime * result
                + ((pdfFilenameSpecialAnnouncement == null) ? 0 : pdfFilenameSpecialAnnouncement.hashCode());
        result = prime * result + ((pricePer100 == null) ? 0 : pricePer100.hashCode());
        result = prime * result + ((primaryDealerAccepted == null) ? 0 : primaryDealerAccepted.hashCode());
        result = prime * result + ((primaryDealerTendered == null) ? 0 : primaryDealerTendered.hashCode());
        result = prime * result + ((refCpiOnDatedDate == null) ? 0 : refCpiOnDatedDate.hashCode());
        result = prime * result + ((refCpiOnIssueDate == null) ? 0 : refCpiOnIssueDate.hashCode());
        result = prime * result + ((reopening == null) ? 0 : reopening.hashCode());
        result = prime * result + ((securityTerm == null) ? 0 : securityTerm.hashCode());
        result = prime * result + ((securityTermDayMonth == null) ? 0 : securityTermDayMonth.hashCode());
        result = prime * result + ((securityTermWeekYear == null) ? 0 : securityTermWeekYear.hashCode());
        result = prime * result + ((securityType == null) ? 0 : securityType.hashCode());
        result = prime * result + ((series == null) ? 0 : series.hashCode());
        result = prime * result + ((somaAccepted == null) ? 0 : somaAccepted.hashCode());
        result = prime * result + ((somaHoldings == null) ? 0 : somaHoldings.hashCode());
        result = prime * result + ((somaIncluded == null) ? 0 : somaIncluded.hashCode());
        result = prime * result + ((somaTendered == null) ? 0 : somaTendered.hashCode());
        result = prime * result + ((spread == null) ? 0 : spread.hashCode());
        result = prime * result
                + ((standardInterestPaymentPer1000 == null) ? 0 : standardInterestPaymentPer1000.hashCode());
        result = prime * result + ((strippable == null) ? 0 : strippable.hashCode());
        result = prime * result + ((term == null) ? 0 : term.hashCode());
        result = prime * result + ((tiinConversionFactorPer1000 == null) ? 0 : tiinConversionFactorPer1000.hashCode());
        result = prime * result + ((tips == null) ? 0 : tips.hashCode());
        result = prime * result + ((totalAccepted == null) ? 0 : totalAccepted.hashCode());
        result = prime * result + ((totalTendered == null) ? 0 : totalTendered.hashCode());
        result = prime * result + ((treasuryDirectAccepted == null) ? 0 : treasuryDirectAccepted.hashCode());
        result = prime * result
                + ((treasuryDirectTendersAccepted == null) ? 0 : treasuryDirectTendersAccepted.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result
                + ((unadjustedAccruedInterestPer1000 == null) ? 0 : unadjustedAccruedInterestPer1000.hashCode());
        result = prime * result + ((unadjustedPrice == null) ? 0 : unadjustedPrice.hashCode());
        result = prime * result + ((updatedTimestamp == null) ? 0 : updatedTimestamp.hashCode());
        result = prime * result + ((xmlFilenameAnnouncement == null) ? 0 : xmlFilenameAnnouncement.hashCode());
        result = prime * result
                + ((xmlFilenameCompetitiveResults == null) ? 0 : xmlFilenameCompetitiveResults.hashCode());
        result = prime * result
                + ((xmlFilenameSpecialAnnouncement == null) ? 0 : xmlFilenameSpecialAnnouncement.hashCode());
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
        Security other = (Security) obj;
        if (accruedInterestPer100 == null) {
            if (other.accruedInterestPer100 != null)
                return false;
        } else if (!accruedInterestPer100.equals(other.accruedInterestPer100))
            return false;
        if (accruedInterestPer1000 == null) {
            if (other.accruedInterestPer1000 != null)
                return false;
        } else if (!accruedInterestPer1000.equals(other.accruedInterestPer1000))
            return false;
        if (adjustedAccruedInterestPer1000 == null) {
            if (other.adjustedAccruedInterestPer1000 != null)
                return false;
        } else if (!adjustedAccruedInterestPer1000.equals(other.adjustedAccruedInterestPer1000))
            return false;
        if (adjustedPrice == null) {
            if (other.adjustedPrice != null)
                return false;
        } else if (!adjustedPrice.equals(other.adjustedPrice))
            return false;
        if (allocationPercentage == null) {
            if (other.allocationPercentage != null)
                return false;
        } else if (!allocationPercentage.equals(other.allocationPercentage))
            return false;
        if (allocationPercentageDecimals == null) {
            if (other.allocationPercentageDecimals != null)
                return false;
        } else if (!allocationPercentageDecimals.equals(other.allocationPercentageDecimals))
            return false;
        if (announcedCusip == null) {
            if (other.announcedCusip != null)
                return false;
        } else if (!announcedCusip.equals(other.announcedCusip))
            return false;
        if (announcementDate == null) {
            if (other.announcementDate != null)
                return false;
        } else if (!announcementDate.equals(other.announcementDate))
            return false;
        if (auctionDate == null) {
            if (other.auctionDate != null)
                return false;
        } else if (!auctionDate.equals(other.auctionDate))
            return false;
        if (auctionDateYear == null) {
            if (other.auctionDateYear != null)
                return false;
        } else if (!auctionDateYear.equals(other.auctionDateYear))
            return false;
        if (auctionFormat == null) {
            if (other.auctionFormat != null)
                return false;
        } else if (!auctionFormat.equals(other.auctionFormat))
            return false;
        if (averageMedianDiscountMargin == null) {
            if (other.averageMedianDiscountMargin != null)
                return false;
        } else if (!averageMedianDiscountMargin.equals(other.averageMedianDiscountMargin))
            return false;
        if (averageMedianDiscountRate == null) {
            if (other.averageMedianDiscountRate != null)
                return false;
        } else if (!averageMedianDiscountRate.equals(other.averageMedianDiscountRate))
            return false;
        if (averageMedianInvestmentRate == null) {
            if (other.averageMedianInvestmentRate != null)
                return false;
        } else if (!averageMedianInvestmentRate.equals(other.averageMedianInvestmentRate))
            return false;
        if (averageMedianPrice == null) {
            if (other.averageMedianPrice != null)
                return false;
        } else if (!averageMedianPrice.equals(other.averageMedianPrice))
            return false;
        if (averageMedianYield == null) {
            if (other.averageMedianYield != null)
                return false;
        } else if (!averageMedianYield.equals(other.averageMedianYield))
            return false;
        if (backDated == null) {
            if (other.backDated != null)
                return false;
        } else if (!backDated.equals(other.backDated))
            return false;
        if (backDatedDate == null) {
            if (other.backDatedDate != null)
                return false;
        } else if (!backDatedDate.equals(other.backDatedDate))
            return false;
        if (bidToCoverRatio == null) {
            if (other.bidToCoverRatio != null)
                return false;
        } else if (!bidToCoverRatio.equals(other.bidToCoverRatio))
            return false;
        if (callDate == null) {
            if (other.callDate != null)
                return false;
        } else if (!callDate.equals(other.callDate))
            return false;
        if (callable == null) {
            if (other.callable != null)
                return false;
        } else if (!callable.equals(other.callable))
            return false;
        if (calledDate == null) {
            if (other.calledDate != null)
                return false;
        } else if (!calledDate.equals(other.calledDate))
            return false;
        if (cashManagementBillCMB == null) {
            if (other.cashManagementBillCMB != null)
                return false;
        } else if (!cashManagementBillCMB.equals(other.cashManagementBillCMB))
            return false;
        if (closingTimeCompetitive == null) {
            if (other.closingTimeCompetitive != null)
                return false;
        } else if (!closingTimeCompetitive.equals(other.closingTimeCompetitive))
            return false;
        if (closingTimeNoncompetitive == null) {
            if (other.closingTimeNoncompetitive != null)
                return false;
        } else if (!closingTimeNoncompetitive.equals(other.closingTimeNoncompetitive))
            return false;
        if (competitiveAccepted == null) {
            if (other.competitiveAccepted != null)
                return false;
        } else if (!competitiveAccepted.equals(other.competitiveAccepted))
            return false;
        if (competitiveBidDecimals == null) {
            if (other.competitiveBidDecimals != null)
                return false;
        } else if (!competitiveBidDecimals.equals(other.competitiveBidDecimals))
            return false;
        if (competitiveTendered == null) {
            if (other.competitiveTendered != null)
                return false;
        } else if (!competitiveTendered.equals(other.competitiveTendered))
            return false;
        if (competitiveTendersAccepted == null) {
            if (other.competitiveTendersAccepted != null)
                return false;
        } else if (!competitiveTendersAccepted.equals(other.competitiveTendersAccepted))
            return false;
        if (corpusCusip == null) {
            if (other.corpusCusip != null)
                return false;
        } else if (!corpusCusip.equals(other.corpusCusip))
            return false;
        if (cpiBaseReferencePeriod == null) {
            if (other.cpiBaseReferencePeriod != null)
                return false;
        } else if (!cpiBaseReferencePeriod.equals(other.cpiBaseReferencePeriod))
            return false;
        if (currentlyOutstanding == null) {
            if (other.currentlyOutstanding != null)
                return false;
        } else if (!currentlyOutstanding.equals(other.currentlyOutstanding))
            return false;
        if (cusip == null) {
            if (other.cusip != null)
                return false;
        } else if (!cusip.equals(other.cusip))
            return false;
        if (datedDate == null) {
            if (other.datedDate != null)
                return false;
        } else if (!datedDate.equals(other.datedDate))
            return false;
        if (directBidderAccepted == null) {
            if (other.directBidderAccepted != null)
                return false;
        } else if (!directBidderAccepted.equals(other.directBidderAccepted))
            return false;
        if (directBidderTendered == null) {
            if (other.directBidderTendered != null)
                return false;
        } else if (!directBidderTendered.equals(other.directBidderTendered))
            return false;
        if (estimatedAmountOfPubliclyHeldMaturingSecuritiesByType == null) {
            if (other.estimatedAmountOfPubliclyHeldMaturingSecuritiesByType != null)
                return false;
        } else if (!estimatedAmountOfPubliclyHeldMaturingSecuritiesByType
                .equals(other.estimatedAmountOfPubliclyHeldMaturingSecuritiesByType))
            return false;
        if (fimaIncluded == null) {
            if (other.fimaIncluded != null)
                return false;
        } else if (!fimaIncluded.equals(other.fimaIncluded))
            return false;
        if (fimaNoncompetitiveAccepted == null) {
            if (other.fimaNoncompetitiveAccepted != null)
                return false;
        } else if (!fimaNoncompetitiveAccepted.equals(other.fimaNoncompetitiveAccepted))
            return false;
        if (fimaNoncompetitiveTendered == null) {
            if (other.fimaNoncompetitiveTendered != null)
                return false;
        } else if (!fimaNoncompetitiveTendered.equals(other.fimaNoncompetitiveTendered))
            return false;
        if (firstInterestPaymentDate == null) {
            if (other.firstInterestPaymentDate != null)
                return false;
        } else if (!firstInterestPaymentDate.equals(other.firstInterestPaymentDate))
            return false;
        if (firstInterestPeriod == null) {
            if (other.firstInterestPeriod != null)
                return false;
        } else if (!firstInterestPeriod.equals(other.firstInterestPeriod))
            return false;
        if (floatingRate == null) {
            if (other.floatingRate != null)
                return false;
        } else if (!floatingRate.equals(other.floatingRate))
            return false;
        if (frnIndexDeterminationDate == null) {
            if (other.frnIndexDeterminationDate != null)
                return false;
        } else if (!frnIndexDeterminationDate.equals(other.frnIndexDeterminationDate))
            return false;
        if (frnIndexDeterminationRate == null) {
            if (other.frnIndexDeterminationRate != null)
                return false;
        } else if (!frnIndexDeterminationRate.equals(other.frnIndexDeterminationRate))
            return false;
        if (highDiscountMargin == null) {
            if (other.highDiscountMargin != null)
                return false;
        } else if (!highDiscountMargin.equals(other.highDiscountMargin))
            return false;
        if (highDiscountRate == null) {
            if (other.highDiscountRate != null)
                return false;
        } else if (!highDiscountRate.equals(other.highDiscountRate))
            return false;
        if (highInvestmentRate == null) {
            if (other.highInvestmentRate != null)
                return false;
        } else if (!highInvestmentRate.equals(other.highInvestmentRate))
            return false;
        if (highPrice == null) {
            if (other.highPrice != null)
                return false;
        } else if (!highPrice.equals(other.highPrice))
            return false;
        if (highYield == null) {
            if (other.highYield != null)
                return false;
        } else if (!highYield.equals(other.highYield))
            return false;
        if (indexRatioOnIssueDate == null) {
            if (other.indexRatioOnIssueDate != null)
                return false;
        } else if (!indexRatioOnIssueDate.equals(other.indexRatioOnIssueDate))
            return false;
        if (indirectBidderAccepted == null) {
            if (other.indirectBidderAccepted != null)
                return false;
        } else if (!indirectBidderAccepted.equals(other.indirectBidderAccepted))
            return false;
        if (indirectBidderTendered == null) {
            if (other.indirectBidderTendered != null)
                return false;
        } else if (!indirectBidderTendered.equals(other.indirectBidderTendered))
            return false;
        if (interestPaymentFrequency == null) {
            if (other.interestPaymentFrequency != null)
                return false;
        } else if (!interestPaymentFrequency.equals(other.interestPaymentFrequency))
            return false;
        if (interestRate == null) {
            if (other.interestRate != null)
                return false;
        } else if (!interestRate.equals(other.interestRate))
            return false;
        if (issueDate == null) {
            if (other.issueDate != null)
                return false;
        } else if (!issueDate.equals(other.issueDate))
            return false;
        if (lowDiscountMargin == null) {
            if (other.lowDiscountMargin != null)
                return false;
        } else if (!lowDiscountMargin.equals(other.lowDiscountMargin))
            return false;
        if (lowDiscountRate == null) {
            if (other.lowDiscountRate != null)
                return false;
        } else if (!lowDiscountRate.equals(other.lowDiscountRate))
            return false;
        if (lowInvestmentRate == null) {
            if (other.lowInvestmentRate != null)
                return false;
        } else if (!lowInvestmentRate.equals(other.lowInvestmentRate))
            return false;
        if (lowPrice == null) {
            if (other.lowPrice != null)
                return false;
        } else if (!lowPrice.equals(other.lowPrice))
            return false;
        if (lowYield == null) {
            if (other.lowYield != null)
                return false;
        } else if (!lowYield.equals(other.lowYield))
            return false;
        if (maturingDate == null) {
            if (other.maturingDate != null)
                return false;
        } else if (!maturingDate.equals(other.maturingDate))
            return false;
        if (maturityDate == null) {
            if (other.maturityDate != null)
                return false;
        } else if (!maturityDate.equals(other.maturityDate))
            return false;
        if (maximumCompetitiveAward == null) {
            if (other.maximumCompetitiveAward != null)
                return false;
        } else if (!maximumCompetitiveAward.equals(other.maximumCompetitiveAward))
            return false;
        if (maximumNoncompetitiveAward == null) {
            if (other.maximumNoncompetitiveAward != null)
                return false;
        } else if (!maximumNoncompetitiveAward.equals(other.maximumNoncompetitiveAward))
            return false;
        if (maximumSingleBid == null) {
            if (other.maximumSingleBid != null)
                return false;
        } else if (!maximumSingleBid.equals(other.maximumSingleBid))
            return false;
        if (minimumBidAmount == null) {
            if (other.minimumBidAmount != null)
                return false;
        } else if (!minimumBidAmount.equals(other.minimumBidAmount))
            return false;
        if (minimumStripAmount == null) {
            if (other.minimumStripAmount != null)
                return false;
        } else if (!minimumStripAmount.equals(other.minimumStripAmount))
            return false;
        if (minimumToIssue == null) {
            if (other.minimumToIssue != null)
                return false;
        } else if (!minimumToIssue.equals(other.minimumToIssue))
            return false;
        if (multiplesToBid == null) {
            if (other.multiplesToBid != null)
                return false;
        } else if (!multiplesToBid.equals(other.multiplesToBid))
            return false;
        if (multiplesToIssue == null) {
            if (other.multiplesToIssue != null)
                return false;
        } else if (!multiplesToIssue.equals(other.multiplesToIssue))
            return false;
        if (nlpExclusionAmount == null) {
            if (other.nlpExclusionAmount != null)
                return false;
        } else if (!nlpExclusionAmount.equals(other.nlpExclusionAmount))
            return false;
        if (nlpReportingThreshold == null) {
            if (other.nlpReportingThreshold != null)
                return false;
        } else if (!nlpReportingThreshold.equals(other.nlpReportingThreshold))
            return false;
        if (noncompetitiveAccepted == null) {
            if (other.noncompetitiveAccepted != null)
                return false;
        } else if (!noncompetitiveAccepted.equals(other.noncompetitiveAccepted))
            return false;
        if (noncompetitiveTendersAccepted == null) {
            if (other.noncompetitiveTendersAccepted != null)
                return false;
        } else if (!noncompetitiveTendersAccepted.equals(other.noncompetitiveTendersAccepted))
            return false;
        if (offeringAmount == null) {
            if (other.offeringAmount != null)
                return false;
        } else if (!offeringAmount.equals(other.offeringAmount))
            return false;
        if (originalCusip == null) {
            if (other.originalCusip != null)
                return false;
        } else if (!originalCusip.equals(other.originalCusip))
            return false;
        if (originalDatedDate == null) {
            if (other.originalDatedDate != null)
                return false;
        } else if (!originalDatedDate.equals(other.originalDatedDate))
            return false;
        if (originalIssueDate == null) {
            if (other.originalIssueDate != null)
                return false;
        } else if (!originalIssueDate.equals(other.originalIssueDate))
            return false;
        if (originalSecurityTerm == null) {
            if (other.originalSecurityTerm != null)
                return false;
        } else if (!originalSecurityTerm.equals(other.originalSecurityTerm))
            return false;
        if (pdfFilenameAnnouncement == null) {
            if (other.pdfFilenameAnnouncement != null)
                return false;
        } else if (!pdfFilenameAnnouncement.equals(other.pdfFilenameAnnouncement))
            return false;
        if (pdfFilenameCompetitiveResults == null) {
            if (other.pdfFilenameCompetitiveResults != null)
                return false;
        } else if (!pdfFilenameCompetitiveResults.equals(other.pdfFilenameCompetitiveResults))
            return false;
        if (pdfFilenameNoncompetitiveResults == null) {
            if (other.pdfFilenameNoncompetitiveResults != null)
                return false;
        } else if (!pdfFilenameNoncompetitiveResults.equals(other.pdfFilenameNoncompetitiveResults))
            return false;
        if (pdfFilenameSpecialAnnouncement == null) {
            if (other.pdfFilenameSpecialAnnouncement != null)
                return false;
        } else if (!pdfFilenameSpecialAnnouncement.equals(other.pdfFilenameSpecialAnnouncement))
            return false;
        if (pricePer100 == null) {
            if (other.pricePer100 != null)
                return false;
        } else if (!pricePer100.equals(other.pricePer100))
            return false;
        if (primaryDealerAccepted == null) {
            if (other.primaryDealerAccepted != null)
                return false;
        } else if (!primaryDealerAccepted.equals(other.primaryDealerAccepted))
            return false;
        if (primaryDealerTendered == null) {
            if (other.primaryDealerTendered != null)
                return false;
        } else if (!primaryDealerTendered.equals(other.primaryDealerTendered))
            return false;
        if (refCpiOnDatedDate == null) {
            if (other.refCpiOnDatedDate != null)
                return false;
        } else if (!refCpiOnDatedDate.equals(other.refCpiOnDatedDate))
            return false;
        if (refCpiOnIssueDate == null) {
            if (other.refCpiOnIssueDate != null)
                return false;
        } else if (!refCpiOnIssueDate.equals(other.refCpiOnIssueDate))
            return false;
        if (reopening == null) {
            if (other.reopening != null)
                return false;
        } else if (!reopening.equals(other.reopening))
            return false;
        if (securityTerm == null) {
            if (other.securityTerm != null)
                return false;
        } else if (!securityTerm.equals(other.securityTerm))
            return false;
        if (securityTermDayMonth == null) {
            if (other.securityTermDayMonth != null)
                return false;
        } else if (!securityTermDayMonth.equals(other.securityTermDayMonth))
            return false;
        if (securityTermWeekYear == null) {
            if (other.securityTermWeekYear != null)
                return false;
        } else if (!securityTermWeekYear.equals(other.securityTermWeekYear))
            return false;
        if (securityType == null) {
            if (other.securityType != null)
                return false;
        } else if (!securityType.equals(other.securityType))
            return false;
        if (series == null) {
            if (other.series != null)
                return false;
        } else if (!series.equals(other.series))
            return false;
        if (somaAccepted == null) {
            if (other.somaAccepted != null)
                return false;
        } else if (!somaAccepted.equals(other.somaAccepted))
            return false;
        if (somaHoldings == null) {
            if (other.somaHoldings != null)
                return false;
        } else if (!somaHoldings.equals(other.somaHoldings))
            return false;
        if (somaIncluded == null) {
            if (other.somaIncluded != null)
                return false;
        } else if (!somaIncluded.equals(other.somaIncluded))
            return false;
        if (somaTendered == null) {
            if (other.somaTendered != null)
                return false;
        } else if (!somaTendered.equals(other.somaTendered))
            return false;
        if (spread == null) {
            if (other.spread != null)
                return false;
        } else if (!spread.equals(other.spread))
            return false;
        if (standardInterestPaymentPer1000 == null) {
            if (other.standardInterestPaymentPer1000 != null)
                return false;
        } else if (!standardInterestPaymentPer1000.equals(other.standardInterestPaymentPer1000))
            return false;
        if (strippable == null) {
            if (other.strippable != null)
                return false;
        } else if (!strippable.equals(other.strippable))
            return false;
        if (term == null) {
            if (other.term != null)
                return false;
        } else if (!term.equals(other.term))
            return false;
        if (tiinConversionFactorPer1000 == null) {
            if (other.tiinConversionFactorPer1000 != null)
                return false;
        } else if (!tiinConversionFactorPer1000.equals(other.tiinConversionFactorPer1000))
            return false;
        if (tips == null) {
            if (other.tips != null)
                return false;
        } else if (!tips.equals(other.tips))
            return false;
        if (totalAccepted == null) {
            if (other.totalAccepted != null)
                return false;
        } else if (!totalAccepted.equals(other.totalAccepted))
            return false;
        if (totalTendered == null) {
            if (other.totalTendered != null)
                return false;
        } else if (!totalTendered.equals(other.totalTendered))
            return false;
        if (treasuryDirectAccepted == null) {
            if (other.treasuryDirectAccepted != null)
                return false;
        } else if (!treasuryDirectAccepted.equals(other.treasuryDirectAccepted))
            return false;
        if (treasuryDirectTendersAccepted == null) {
            if (other.treasuryDirectTendersAccepted != null)
                return false;
        } else if (!treasuryDirectTendersAccepted.equals(other.treasuryDirectTendersAccepted))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        if (unadjustedAccruedInterestPer1000 == null) {
            if (other.unadjustedAccruedInterestPer1000 != null)
                return false;
        } else if (!unadjustedAccruedInterestPer1000.equals(other.unadjustedAccruedInterestPer1000))
            return false;
        if (unadjustedPrice == null) {
            if (other.unadjustedPrice != null)
                return false;
        } else if (!unadjustedPrice.equals(other.unadjustedPrice))
            return false;
        if (updatedTimestamp == null) {
            if (other.updatedTimestamp != null)
                return false;
        } else if (!updatedTimestamp.equals(other.updatedTimestamp))
            return false;
        if (xmlFilenameAnnouncement == null) {
            if (other.xmlFilenameAnnouncement != null)
                return false;
        } else if (!xmlFilenameAnnouncement.equals(other.xmlFilenameAnnouncement))
            return false;
        if (xmlFilenameCompetitiveResults == null) {
            if (other.xmlFilenameCompetitiveResults != null)
                return false;
        } else if (!xmlFilenameCompetitiveResults.equals(other.xmlFilenameCompetitiveResults))
            return false;
        if (xmlFilenameSpecialAnnouncement == null) {
            if (other.xmlFilenameSpecialAnnouncement != null)
                return false;
        } else if (!xmlFilenameSpecialAnnouncement.equals(other.xmlFilenameSpecialAnnouncement))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Security [cusip=" + cusip + ", issueDate=" + issueDate + ", securityType=" + securityType
            + ", securityTerm=" + securityTerm + ", maturityDate=" + maturityDate + ", interestRate=" + interestRate
            + ", refCpiOnIssueDate=" + refCpiOnIssueDate + ", refCpiOnDatedDate=" + refCpiOnDatedDate
            + ", announcementDate=" + announcementDate + ", auctionDate=" + auctionDate + ", auctionDateYear="
            + auctionDateYear + ", datedDate=" + datedDate + ", accruedInterestPer1000=" + accruedInterestPer1000
            + ", accruedInterestPer100=" + accruedInterestPer100 + ", adjustedAccruedInterestPer1000="
            + adjustedAccruedInterestPer1000 + ", adjustedPrice=" + adjustedPrice + ", allocationPercentage="
            + allocationPercentage + ", allocationPercentageDecimals=" + allocationPercentageDecimals
            + ", announcedCusip=" + announcedCusip + ", auctionFormat=" + auctionFormat
            + ", averageMedianDiscountRate=" + averageMedianDiscountRate + ", averageMedianInvestmentRate="
            + averageMedianInvestmentRate + ", averageMedianPrice=" + averageMedianPrice
            + ", averageMedianDiscountMargin=" + averageMedianDiscountMargin + ", averageMedianYield="
            + averageMedianYield + ", backDated=" + backDated + ", backDatedDate=" + backDatedDate
            + ", bidToCoverRatio=" + bidToCoverRatio + ", callDate=" + callDate + ", callable=" + callable
            + ", calledDate=" + calledDate + ", cashManagementBillCMB=" + cashManagementBillCMB
            + ", closingTimeCompetitive=" + closingTimeCompetitive + ", closingTimeNoncompetitive="
            + closingTimeNoncompetitive + ", competitiveAccepted=" + competitiveAccepted
            + ", competitiveBidDecimals=" + competitiveBidDecimals + ", competitiveTendered=" + competitiveTendered
            + ", competitiveTendersAccepted=" + competitiveTendersAccepted + ", corpusCusip=" + corpusCusip
            + ", cpiBaseReferencePeriod=" + cpiBaseReferencePeriod + ", currentlyOutstanding="
            + currentlyOutstanding + ", directBidderAccepted=" + directBidderAccepted + ", directBidderTendered="
            + directBidderTendered + ", estimatedAmountOfPubliclyHeldMaturingSecuritiesByType="
            + estimatedAmountOfPubliclyHeldMaturingSecuritiesByType + ", fimaIncluded=" + fimaIncluded
            + ", fimaNoncompetitiveAccepted=" + fimaNoncompetitiveAccepted + ", fimaNoncompetitiveTendered="
            + fimaNoncompetitiveTendered + ", firstInterestPeriod=" + firstInterestPeriod
            + ", firstInterestPaymentDate=" + firstInterestPaymentDate + ", floatingRate=" + floatingRate
            + ", frnIndexDeterminationDate=" + frnIndexDeterminationDate + ", frnIndexDeterminationRate="
            + frnIndexDeterminationRate + ", highDiscountRate=" + highDiscountRate + ", highInvestmentRate="
            + highInvestmentRate + ", highPrice=" + highPrice + ", highDiscountMargin=" + highDiscountMargin
            + ", highYield=" + highYield + ", indexRatioOnIssueDate=" + indexRatioOnIssueDate
            + ", indirectBidderAccepted=" + indirectBidderAccepted + ", indirectBidderTendered="
            + indirectBidderTendered + ", interestPaymentFrequency=" + interestPaymentFrequency
            + ", lowDiscountRate=" + lowDiscountRate + ", lowInvestmentRate=" + lowInvestmentRate + ", lowPrice="
            + lowPrice + ", lowDiscountMargin=" + lowDiscountMargin + ", lowYield=" + lowYield + ", maturingDate="
            + maturingDate + ", maximumCompetitiveAward=" + maximumCompetitiveAward
            + ", maximumNoncompetitiveAward=" + maximumNoncompetitiveAward + ", maximumSingleBid="
            + maximumSingleBid + ", minimumBidAmount=" + minimumBidAmount + ", minimumStripAmount="
            + minimumStripAmount + ", minimumToIssue=" + minimumToIssue + ", multiplesToBid=" + multiplesToBid
            + ", multiplesToIssue=" + multiplesToIssue + ", nlpExclusionAmount=" + nlpExclusionAmount
            + ", nlpReportingThreshold=" + nlpReportingThreshold + ", noncompetitiveAccepted="
            + noncompetitiveAccepted + ", noncompetitiveTendersAccepted=" + noncompetitiveTendersAccepted
            + ", offeringAmount=" + offeringAmount + ", originalCusip=" + originalCusip + ", originalDatedDate="
            + originalDatedDate + ", originalIssueDate=" + originalIssueDate + ", originalSecurityTerm="
            + originalSecurityTerm + ", pdfFilenameAnnouncement=" + pdfFilenameAnnouncement
            + ", pdfFilenameCompetitiveResults=" + pdfFilenameCompetitiveResults
            + ", pdfFilenameNoncompetitiveResults=" + pdfFilenameNoncompetitiveResults
            + ", pdfFilenameSpecialAnnouncement=" + pdfFilenameSpecialAnnouncement + ", pricePer100=" + pricePer100
            + ", primaryDealerAccepted=" + primaryDealerAccepted + ", primaryDealerTendered="
            + primaryDealerTendered + ", reopening=" + reopening + ", securityTermDayMonth=" + securityTermDayMonth
            + ", securityTermWeekYear=" + securityTermWeekYear + ", series=" + series + ", somaAccepted="
            + somaAccepted + ", somaHoldings=" + somaHoldings + ", somaIncluded=" + somaIncluded + ", somaTendered="
            + somaTendered + ", spread=" + spread + ", standardInterestPaymentPer1000="
            + standardInterestPaymentPer1000 + ", strippable=" + strippable + ", term=" + term
            + ", tiinConversionFactorPer1000=" + tiinConversionFactorPer1000 + ", tips=" + tips + ", totalAccepted="
            + totalAccepted + ", totalTendered=" + totalTendered + ", treasuryDirectAccepted="
            + treasuryDirectAccepted + ", treasuryDirectTendersAccepted=" + treasuryDirectTendersAccepted
            + ", type=" + type + ", unadjustedAccruedInterestPer1000=" + unadjustedAccruedInterestPer1000
            + ", unadjustedPrice=" + unadjustedPrice + ", updatedTimestamp=" + updatedTimestamp
            + ", xmlFilenameAnnouncement=" + xmlFilenameAnnouncement + ", xmlFilenameCompetitiveResults="
            + xmlFilenameCompetitiveResults + ", xmlFilenameSpecialAnnouncement=" + xmlFilenameSpecialAnnouncement
            + ", getCreatedDate()=" + getCreatedDate() + ", getUpdatedDate()=" + getUpdatedDate()
            + ", getVersion()=" + getVersion() + ", getPrimaryKey()=" + getPrimaryKey() + "]";
    }
}
