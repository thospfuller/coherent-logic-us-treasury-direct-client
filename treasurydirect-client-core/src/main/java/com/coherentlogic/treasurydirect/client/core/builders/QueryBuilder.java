package com.coherentlogic.treasurydirect.client.core.builders;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import com.coherentlogic.coherent.data.adapter.core.builders.rest.AbstractRESTQueryBuilder;
import com.coherentlogic.coherent.data.adapter.core.cache.CacheServiceProviderSpecification;
import com.coherentlogic.coherent.data.adapter.core.util.WelcomeMessage;
import com.coherentlogic.coherent.data.model.core.domain.SerializableBean;
import com.coherentlogic.coherent.data.model.core.util.Utils;
import com.coherentlogic.treasurydirect.client.core.domain.Debts;
import com.coherentlogic.treasurydirect.client.core.domain.Securities;
import com.coherentlogic.treasurydirect.client.core.exceptions.UnsupportedTypeException;
import com.coherentlogic.treasurydirect.client.core.services.GoogleAnalyticsMeasurementService;

/**
 * Class that allows the developer to construct and execute a query to the TreasuryDirect.gov web services.
 * <p>
 * Note that this class is <b>not</b> thread-safe and cannot be used as a member-level property -- if this is required,
 * use the
 * {@link com.coherentlogic.treasurydirect.client.core.factories.QueryBuilderFactory QueryBuilderFactory} class.
 * <p>
 * In order to facilitate method-chaining each <i>with</i> method returns a reference to this object.
 * <p>
 * For examples, refer to the QueryBuilderTest class.
 *
 * @see <a href="https://www.treasurydirect.gov/webapis/webapisindex.htm">Web APIs</a>
 *
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class QueryBuilder extends AbstractRESTQueryBuilder<String> {

    private static final Logger log = LoggerFactory.getLogger(QueryBuilder.class);

    public static final String BEAN_NAME = "queryBuilder";

    static final String[] WELCOME_MESSAGE = {
        "*************************************************************************************************************",
        "***                                                                                                       ***",
        "***                                 Welcome to the Treasury Direct Client                                 ***",
        "***                                                                                                       ***",
        "***                                        Version 0.8.5-RELEASE                                         ***",
        "***                                                                                                       ***",
        "***                              Please take a moment to follow us on Twitter:                            ***",
        "***                                                                                                       ***",
        "***                                    www.twitter.com/CoherentMktData                                    ***",
        "***                                                                                                       ***",
        "***                                          or on LinkedIn:                                              ***",
        "***                                                                                                       ***",
        "***                            www.linkedin.com/company/coherent-logic-limited                            ***",
        "***                                                                                                       ***",
        "***                            The project and issue tracker can be found here:                           ***",
        "***                                                                                                       ***",
        "***              https://bitbucket.org/CoherentLogic/coherent-logic-us-treasury-direct-client             ***",
        "***                                                                                                       ***",
        "*** ----------------------------------------------------------------------------------------------------- ***",
        "***                                                                                                       ***",
        "*** BE ADVISED:                                                                                           ***",
        "***                                                                                                       ***",
        "*** This framework uses the Google Analytics Measurement API (GAM) to track framework usage  information. ***",
        "*** As this software is open-source, you are welcomed to review our use of GAM -- please  see  the  class ***",
        "*** named  com.coherentlogic.fred.client.core.services.GoogleAnalyticsMeasurementService  and  feel  free ***",
        "*** to send us an email if you have further questions.                                                    ***",
        "***                                                                                                       ***",
        "*** We do NOT recommend disabling this feature however we offer the option below, just add the following  ***",
        "*** VM parameter and tracking will be disabled:                                                           ***",
        "***                                                                                                       ***",
        "*** -DGOOGLE_ANALYTICS_TRACKING=false                                                                     ***",
        "***                                                                                                       ***",
        "*** ----------------------------------------------------------------------------------------------------- ***",
        "***                                                                                                       ***",
        "*** We offer support and consulting services to businesses that  utilize  this  framework  or  that  have ***",
        "*** custom financial data acquisition projects -- inquiries can be directed to:                           ***",
        "***                                                                                                       ***",
        "*** [M] sales@coherentlogic.com                                                                           ***",
        "*** [T] +1.571.306.3403 (GMT-5)                                                                           ***",
        "***                                                                                                       ***",
        "*************************************************************************************************************"
    };

    static {

        GoogleAnalyticsMeasurementService googleAnalyticsMeasurementService = new GoogleAnalyticsMeasurementService ();

        if (googleAnalyticsMeasurementService.shouldTrack()) {
            try {
                googleAnalyticsMeasurementService.fireGAFrameworkUsageEvent ();
            } catch (Throwable thrown) {
                log.warn("fireGAFrameworkUsageEvent: method call failed. This exception can be ignored, and the "
                    + "framework will function without issue.", thrown);
            }
        }

        WelcomeMessage welcomeMessage = new WelcomeMessage();

        for (String next : WELCOME_MESSAGE) {
            welcomeMessage.addText(next);
        }

        welcomeMessage.display();
    }

    public static enum SecurityType {
        Bill,
        Note,
        Bond,
        CMB,
        TIPS,
        FRN;
    }

    public static enum Field {
        cusip,
        issueDate,
        securityType,
        securityTerm,
        maturityDate,
        interestRate,
        refCpiOnIssueDate,
        announcementDate,
        auctionDate,
        xmlFilenameCompetitiveResults,
        datedDate,
        refCpiOnDatedDate,
        AccruedInterestPer1000,
        AccruedInterestPer100,
        AdjustedAccruedInterestPer1000,
        AdjustedPrice,
        AllocationPercentage,
        AllocationPercentageDecimals,
        AnnouncedCusip,
        AuctionFormat,
        AverageMedianDiscountRate,
        AverageMedianInvestmentRate,
        AverageMedianPrice,
        AverageMedianDiscountMargin,
        AverageMedianYield,
        BackDated,
        BackDatedDate,
        BidToCoverRatio,
        CallDate,
        Callable,
        CalledDate,
        CashManagementBillCMB,
        ClosingTimeCompetitive,
        ClosingTimeNoncompetitive,
        CompetitiveAccepted,
        CompetitiveBidDecimals,
        CompetitiveTendered,
        CompetitiveTendersAccepted,
        CorpusCusip,
        CpiBaseReferencePeriod,
        CurrentlyOutstanding,
        DirectBidderAccepted,
        DirectBidderTendered,
        EstimatedAmountOfPubliclyHeldMaturingSecuritiesByType,
        FimaIncluded,
        FimaNoncompetitiveAccepted,
        FimaNoncompetitiveTendered,
        FirstInterestPeriod,
        FirstInterestPaymentDate,
        FloatingRate,
        FrnIndexDeterminationDate,
        FrnIndexDeterminationRate,
        HighDiscountRate,
        HighInvestmentRate,
        HighPrice,
        HighDiscountMargin,
        HighYield,
        IndexRatioOnIssueDate,
        IndirectBidderAccepted,
        IndirectBidderTendered,
        InterestPaymentFrequency,
        LowDiscountRate,
        LowInvestmentRate,
        LowPrice,
        LowDiscountMargin,
        LowYield,
        MaturingDate,
        MaximumCompetitiveAward,
        MaximumNoncompetitiveAward,
        MaximumSingleBid,
        MinimumBidAmount,
        MinimumStripAmount,
        MinimumToIssue,
        MultiplesToBid,
        MultiplesToIssue,
        NlpExclusionAmount,
        NlpReportingThreshold,
        NoncompetitiveAccepted,
        NoncompetitiveTendersAccepted,
        OfferingAmount,
        OriginalCusip,
        OriginalDatedDate,
        OriginalIssueDate,
        OriginalSecurityTerm,
        PdfFilenameAnnouncement,
        PdfFilenameCompetitiveResults,
        PdfFilenameNoncompetitiveResults,
        PdfFilenameSpecialAnnouncement,
        PricePer100,
        PrimaryDealerAccepted,
        PrimaryDealerTendered,
        Reopening,
        SecurityTermDayMonth,
        SecurityTermWeekYear,
        Series,
        SomaAccepted,
        SomaHoldings,
        SomaIncluded,
        SomaTendered,
        Spread,
        StandardInterestPaymentPer1000,
        Strippable,
        Term,
        TiinConversionFactorPer1000,
        Tips,
        TotalAccepted,
        TotalTendered,
        TreasuryDirectAccepted,
        TreasuryDirectTendersAccepted,
        Type,
        UnadjustedAccruedInterestPer1000,
        UnadjustedPrice,
        UpdatedTimestamp,
        XmlFilenameAnnouncement,
        XmlFilenameSpecialAnnouncement,
        AuctionDateYear
    }

    public static final String DEFAULT_URI = "http://www.treasurydirect.gov/",
        TA_WS = "TA_WS",
        NP_WS = "NP_WS",
        SECURITIES = "securities",
        PAGE_SIZE = "pagesize",
        PAGE_NUM = "pagenum",
        DAYS = "days",
        REOPENING = "reopening",
        YES = "Yes",
        NO = "No",
        DEBT = "debt",
        CURRENT = "current",
        SEARCH = "search",
        START_DATE = "startdate",
        END_DATE = "enddate",
        ANNOUNCED = "announced",
        AUCTIONED = "auctioned",
        FORMAT = "format",
        JSON = "json",
        TYPE = "type",
        BILL = "Bill",
        NOTE = "Note",
        BOND = "Bond",
        CMB = "CMB",
        TIPS = "TIPS",
        FRN = "FRN",
        DATE_FIELD_NAME = "dateFieldName",
        TODAY = "today",
        NOT_NULL = "notNull";

    static final DateFormat dateFormat = new SimpleDateFormat ("yyyy.MM.dd");

    private final ResponseExtractor<Securities> securitiesExtractor;
    
    private final ResponseExtractor<Debts> debtsExtractor;

    public QueryBuilder(
        RestTemplate restTemplate,
        ResponseExtractor<Securities> securitiesExtractor,
        ResponseExtractor<Debts> debtsExtractor
    ) {
        this(restTemplate, DEFAULT_URI, securitiesExtractor, debtsExtractor);
    }

    public QueryBuilder(
        RestTemplate restTemplate,
        CacheServiceProviderSpecification<String, Object> cacheServiceProviderSpecification,
        ResponseExtractor<Securities> securitiesExtractor,
        ResponseExtractor<Debts> debtsExtractor
    ) {
        this (restTemplate, DEFAULT_URI, cacheServiceProviderSpecification, securitiesExtractor, debtsExtractor);
    }

    public QueryBuilder(
        RestTemplate restTemplate,
        String uri,
//        InReturnAdapterSpecification<RequestBody, String> requestBodyAdapter,
        ResponseExtractor<Securities> securitiesExtractor,
        ResponseExtractor<Debts> debtsExtractor
    ) {
        super(restTemplate, uri);
//        this.requestBodyAdapter = requestBodyAdapter;
//        this.requestBody = new RequestBody (this);
//        headers = new HashMap<String, String> ();
        this.securitiesExtractor = securitiesExtractor;
        this.debtsExtractor = debtsExtractor;
    }

    public QueryBuilder(
        RestTemplate restTemplate,
        String uri,
        CacheServiceProviderSpecification<String, Object> cacheServiceProviderSpecification,
        ResponseExtractor<Securities> securitiesExtractor,
        ResponseExtractor<Debts> debtsExtractor
    ) {
        super(restTemplate, uri, cacheServiceProviderSpecification);
//            this.requestBodyAdapter = requestBodyAdapter;
//            this.requestBody = new RequestBody (this);
//            headers = new HashMap<String, String> ();
        this.securitiesExtractor = securitiesExtractor;
        this.debtsExtractor = debtsExtractor;
    }

//    public QueryBuilder(
//        RestTemplate restTemplate,
//        String uri,
//        CacheServiceProviderSpecification<String, Object> cache
//    ) {
//        super(restTemplate, uri, cache);
//    }
//
//    public QueryBuilder(RestTemplate restTemplate, String uri) {
//        super(restTemplate, uri);
//    }
//
//    public QueryBuilder(
//        RestTemplate restTemplate,
//        UriBuilder uriBuilder,
//        CacheServiceProviderSpecification<String, Object> cache
//    ) {
//        super(restTemplate, uriBuilder, cache);
//    }
//
//    public QueryBuilder(RestTemplate restTemplate, UriBuilder uriBuilder) {
//        super(restTemplate, uriBuilder);
//    }

    protected QueryBuilder TA_WS () {

        extendPathWith(TA_WS);

        return this;
    }

    protected QueryBuilder NP_WS () {

        extendPathWith(NP_WS);

        return this;
    }

//    /securities/Cusip(9#)/Date(MM/DD/YYYY)
    
    public QueryBuilder securities () {
        return (QueryBuilder) TA_WS().extendPathWith(SECURITIES);
    }

    public QueryBuilder securities (SecurityType securityType) {

        Utils.assertNotNull ("securityType", securityType);

        TA_WS();
        extendPathWith(SECURITIES);
        extendPathWith(securityType.toString());

        return this;
    }

    public QueryBuilder securities (String cusip, Date date) {

//        assertSizeExactlyNAlphaNumericChars(9, cusip);

        extendPathWith(SECURITIES);

        String dateText = dateFormat.format(date);

        return securities(cusip, dateText);
    }

    public QueryBuilder securities (String cusip, String date) {

        TA_WS();
        extendPathWith(SECURITIES);
        extendPathWith(cusip);
        extendPathWith(date);

        return this;
    }

    /**
     * Maximum number of results to return -- ie. 2.
     */
    public QueryBuilder withPageSize (Number pageSize) {

        addParameter(PAGE_SIZE, pageSize);

        return this;
    }

    /**
     * Maximum number of results to return -- ie. 2.
     */
    public QueryBuilder withPageSize (String pageSize) {

        addParameter(PAGE_SIZE, pageSize);

        return this;
    }

    /**
     * Maximum number of results to return -- ie. 2.
     */
    public QueryBuilder withPageNum (Number pageNum) {

        addParameter(PAGE_NUM, pageNum);

        return this;
    }

    /**
     * Maximum number of results to return -- ie. 2.
     */
    public QueryBuilder withPageNum (String pageNum) {

        addParameter(PAGE_NUM, pageNum);

        return this;
    }

    /**
     * How many days ago you want results for? (Note: days=0 will give you today’s results only)
     */
    public QueryBuilder withDays (Number days) {

        addParameter(DAYS, days);

        return this;
    }

    /**
     * How many days ago you want results for? (Note: days=0 will give you today’s results only)
     */
    public QueryBuilder withDays (String days) {

        addParameter(DAYS, days);

        return this;
    }

//    /**
//     * Used to filter securities by reopening status.
//     *
//     * @param flag Either 'Yes' or 'No';
//     */
//    public QueryBuilder withReopening (String flag) {
//
//        addParameter(REOPENING, flag);
//
//        return this;
//    }

    /**
     * Used to filter securities by reopening status.
     *
     * @param flag Either 'Yes' (true) or 'No' (false);
     */
    public QueryBuilder withReopening (boolean flag) {
        return withReopening (flag == true ? YES : NO);
    }

    /**
     * Used to filter securities by reopening status.
     */
    public QueryBuilder withReopeningAsYes () {
        return withReopening (YES);
    }

    /**
     * Used to filter securities by reopening status.
     */
    public QueryBuilder withReopeningAsNo () {
        return withReopening (NO);
    }

    /**
     * Determines which date field to use for startDate and endDate.
     */
    public QueryBuilder withDateFieldName (String dateFieldName) {

        addParameter(DATE_FIELD_NAME, dateFieldName);

        return this;
    }

    /**
     * Determines which date field to use for startDate and endDate.
     */
    public QueryBuilder withDateFieldName (Field field) {

        addParameter(DATE_FIELD_NAME, field.toString());

        return this;
    }

    /**
     * Notes:
     *
     * Accepts parameter names that match camel cased variable names, for example
     * auctionDate=2013-05-25&interestRate=7.5
     *
     * When using variable names as parameters you can supply a value of notNull, for example auctionDate=notNull
     * Dates accept a value of "today" without quotes, for example issueDate=today
     *
     * This URL returns data based on the parameters passed.  By default it will display all securities. The list of
     * fields which can be used as parameter names is as follows (when passing parameters remember to make the first
     * letter lower case):
     *
     * Example
     *
     * http://www.treasurydirect.gov/TA_WS/securities/search?cusip= 912796CH0&format=html+
     */
    QueryBuilder withFieldAndValue (Field field, String value) {

        addParameter(field.toString(), value);

        return this;
    }

    // Autogenerated methods begins.

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCusip (String value) {
        return withFieldAndValue (Field.cusip, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCusipAsNotNull () {
        return withFieldAndValue (Field.cusip, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withIssueDate (String value) {
        return withFieldAndValue (Field.issueDate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withIssueDateAsNotNull () {
        return withFieldAndValue (Field.issueDate, NOT_NULL);
    }
    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withIssueDateAsToday () {
        return withFieldAndValue (Field.issueDate, TODAY);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withSecurityType (String value) {
        return withFieldAndValue (Field.securityType, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withSecurityTypeAsNotNull () {
        return withFieldAndValue (Field.securityType, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withSecurityTerm (String value) {
        return withFieldAndValue (Field.securityTerm, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withSecurityTermAsNotNull () {
        return withFieldAndValue (Field.securityTerm, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMaturityDate (String value) {
        return withFieldAndValue (Field.maturityDate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMaturityDateAsNotNull () {
        return withFieldAndValue (Field.maturityDate, NOT_NULL);
    }
    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMaturityDateAsToday () {
        return withFieldAndValue (Field.maturityDate, TODAY);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withInterestRate (String value) {
        return withFieldAndValue (Field.interestRate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withInterestRateAsNotNull () {
        return withFieldAndValue (Field.interestRate, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withRefCpiOnIssueDate (String value) {
        return withFieldAndValue (Field.refCpiOnIssueDate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withRefCpiOnIssueDateAsNotNull () {
        return withFieldAndValue (Field.refCpiOnIssueDate, NOT_NULL);
    }
    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withRefCpiOnIssueDateAsToday () {
        return withFieldAndValue (Field.refCpiOnIssueDate, TODAY);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAnnouncementDate (String value) {
        return withFieldAndValue (Field.announcementDate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAnnouncementDateAsNotNull () {
        return withFieldAndValue (Field.announcementDate, NOT_NULL);
    }
    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAnnouncementDateAsToday () {
        return withFieldAndValue (Field.announcementDate, TODAY);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAuctionDate (String value) {
        return withFieldAndValue (Field.auctionDate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAuctionDateAsNotNull () {
        return withFieldAndValue (Field.auctionDate, NOT_NULL);
    }
    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAuctionDateAsToday () {
        return withFieldAndValue (Field.auctionDate, TODAY);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withXmlFilenameCompetitiveResults (String value) {
        return withFieldAndValue (Field.xmlFilenameCompetitiveResults, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withXmlFilenameCompetitiveResultsAsNotNull () {
        return withFieldAndValue (Field.xmlFilenameCompetitiveResults, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withDatedDate (String value) {
        return withFieldAndValue (Field.datedDate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withDatedDateAsNotNull () {
        return withFieldAndValue (Field.datedDate, NOT_NULL);
    }
    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withDatedDateAsToday () {
        return withFieldAndValue (Field.datedDate, TODAY);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withRefCpiOnDatedDate (String value) {
        return withFieldAndValue (Field.refCpiOnDatedDate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withRefCpiOnDatedDateAsNotNull () {
        return withFieldAndValue (Field.refCpiOnDatedDate, NOT_NULL);
    }
    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withRefCpiOnDatedDateAsToday () {
        return withFieldAndValue (Field.refCpiOnDatedDate, TODAY);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAccruedInterestPer1000 (String value) {
        return withFieldAndValue (Field.AccruedInterestPer1000, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAccruedInterestPer1000AsNotNull () {
        return withFieldAndValue (Field.AccruedInterestPer1000, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAccruedInterestPer100 (String value) {
        return withFieldAndValue (Field.AccruedInterestPer100, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAccruedInterestPer100AsNotNull () {
        return withFieldAndValue (Field.AccruedInterestPer100, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAdjustedAccruedInterestPer1000 (String value) {
        return withFieldAndValue (Field.AdjustedAccruedInterestPer1000, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAdjustedAccruedInterestPer1000AsNotNull () {
        return withFieldAndValue (Field.AdjustedAccruedInterestPer1000, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAdjustedPrice (String value) {
        return withFieldAndValue (Field.AdjustedPrice, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAdjustedPriceAsNotNull () {
        return withFieldAndValue (Field.AdjustedPrice, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAllocationPercentage (String value) {
        return withFieldAndValue (Field.AllocationPercentage, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAllocationPercentageAsNotNull () {
        return withFieldAndValue (Field.AllocationPercentage, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAllocationPercentageDecimals (String value) {
        return withFieldAndValue (Field.AllocationPercentageDecimals, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAllocationPercentageDecimalsAsNotNull () {
        return withFieldAndValue (Field.AllocationPercentageDecimals, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAnnouncedCusip (String value) {
        return withFieldAndValue (Field.AnnouncedCusip, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAnnouncedCusipAsNotNull () {
        return withFieldAndValue (Field.AnnouncedCusip, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAuctionFormat (String value) {
        return withFieldAndValue (Field.AuctionFormat, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAuctionFormatAsNotNull () {
        return withFieldAndValue (Field.AuctionFormat, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAverageMedianDiscountRate (String value) {
        return withFieldAndValue (Field.AverageMedianDiscountRate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAverageMedianDiscountRateAsNotNull () {
        return withFieldAndValue (Field.AverageMedianDiscountRate, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAverageMedianInvestmentRate (String value) {
        return withFieldAndValue (Field.AverageMedianInvestmentRate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAverageMedianInvestmentRateAsNotNull () {
        return withFieldAndValue (Field.AverageMedianInvestmentRate, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAverageMedianPrice (String value) {
        return withFieldAndValue (Field.AverageMedianPrice, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAverageMedianPriceAsNotNull () {
        return withFieldAndValue (Field.AverageMedianPrice, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAverageMedianDiscountMargin (String value) {
        return withFieldAndValue (Field.AverageMedianDiscountMargin, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAverageMedianDiscountMarginAsNotNull () {
        return withFieldAndValue (Field.AverageMedianDiscountMargin, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAverageMedianYield (String value) {
        return withFieldAndValue (Field.AverageMedianYield, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAverageMedianYieldAsNotNull () {
        return withFieldAndValue (Field.AverageMedianYield, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withBackDated (String value) {
        return withFieldAndValue (Field.BackDated, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withBackDatedAsNotNull () {
        return withFieldAndValue (Field.BackDated, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withBackDatedDate (String value) {
        return withFieldAndValue (Field.BackDatedDate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withBackDatedDateAsNotNull () {
        return withFieldAndValue (Field.BackDatedDate, NOT_NULL);
    }
    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withBackDatedDateAsToday () {
        return withFieldAndValue (Field.BackDatedDate, TODAY);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withBidToCoverRatio (String value) {
        return withFieldAndValue (Field.BidToCoverRatio, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withBidToCoverRatioAsNotNull () {
        return withFieldAndValue (Field.BidToCoverRatio, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCallDate (String value) {
        return withFieldAndValue (Field.CallDate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCallDateAsNotNull () {
        return withFieldAndValue (Field.CallDate, NOT_NULL);
    }
    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCallDateAsToday () {
        return withFieldAndValue (Field.CallDate, TODAY);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCallable (String value) {
        return withFieldAndValue (Field.Callable, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCallableAsNotNull () {
        return withFieldAndValue (Field.Callable, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCalledDate (String value) {
        return withFieldAndValue (Field.CalledDate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCalledDateAsNotNull () {
        return withFieldAndValue (Field.CalledDate, NOT_NULL);
    }
    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCalledDateAsToday () {
        return withFieldAndValue (Field.CalledDate, TODAY);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCashManagementBillCMB (String value) {
        return withFieldAndValue (Field.CashManagementBillCMB, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCashManagementBillCMBAsNotNull () {
        return withFieldAndValue (Field.CashManagementBillCMB, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withClosingTimeCompetitive (String value) {
        return withFieldAndValue (Field.ClosingTimeCompetitive, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withClosingTimeCompetitiveAsNotNull () {
        return withFieldAndValue (Field.ClosingTimeCompetitive, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withClosingTimeNoncompetitive (String value) {
        return withFieldAndValue (Field.ClosingTimeNoncompetitive, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withClosingTimeNoncompetitiveAsNotNull () {
        return withFieldAndValue (Field.ClosingTimeNoncompetitive, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCompetitiveAccepted (String value) {
        return withFieldAndValue (Field.CompetitiveAccepted, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCompetitiveAcceptedAsNotNull () {
        return withFieldAndValue (Field.CompetitiveAccepted, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCompetitiveBidDecimals (String value) {
        return withFieldAndValue (Field.CompetitiveBidDecimals, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCompetitiveBidDecimalsAsNotNull () {
        return withFieldAndValue (Field.CompetitiveBidDecimals, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCompetitiveTendered (String value) {
        return withFieldAndValue (Field.CompetitiveTendered, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCompetitiveTenderedAsNotNull () {
        return withFieldAndValue (Field.CompetitiveTendered, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCompetitiveTendersAccepted (String value) {
        return withFieldAndValue (Field.CompetitiveTendersAccepted, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCompetitiveTendersAcceptedAsNotNull () {
        return withFieldAndValue (Field.CompetitiveTendersAccepted, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCorpusCusip (String value) {
        return withFieldAndValue (Field.CorpusCusip, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCorpusCusipAsNotNull () {
        return withFieldAndValue (Field.CorpusCusip, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCpiBaseReferencePeriod (String value) {
        return withFieldAndValue (Field.CpiBaseReferencePeriod, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCpiBaseReferencePeriodAsNotNull () {
        return withFieldAndValue (Field.CpiBaseReferencePeriod, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCurrentlyOutstanding (String value) {
        return withFieldAndValue (Field.CurrentlyOutstanding, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCurrentlyOutstandingAsNotNull () {
        return withFieldAndValue (Field.CurrentlyOutstanding, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withDirectBidderAccepted (String value) {
        return withFieldAndValue (Field.DirectBidderAccepted, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withDirectBidderAcceptedAsNotNull () {
        return withFieldAndValue (Field.DirectBidderAccepted, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withDirectBidderTendered (String value) {
        return withFieldAndValue (Field.DirectBidderTendered, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withDirectBidderTenderedAsNotNull () {
        return withFieldAndValue (Field.DirectBidderTendered, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withEstimatedAmountOfPubliclyHeldMaturingSecuritiesByType (String value) {
        return withFieldAndValue (Field.EstimatedAmountOfPubliclyHeldMaturingSecuritiesByType, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withEstimatedAmountOfPubliclyHeldMaturingSecuritiesByTypeAsNotNull () {
        return withFieldAndValue (Field.EstimatedAmountOfPubliclyHeldMaturingSecuritiesByType, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withFimaIncluded (String value) {
        return withFieldAndValue (Field.FimaIncluded, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withFimaIncludedAsNotNull () {
        return withFieldAndValue (Field.FimaIncluded, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withFimaNoncompetitiveAccepted (String value) {
        return withFieldAndValue (Field.FimaNoncompetitiveAccepted, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withFimaNoncompetitiveAcceptedAsNotNull () {
        return withFieldAndValue (Field.FimaNoncompetitiveAccepted, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withFimaNoncompetitiveTendered (String value) {
        return withFieldAndValue (Field.FimaNoncompetitiveTendered, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withFimaNoncompetitiveTenderedAsNotNull () {
        return withFieldAndValue (Field.FimaNoncompetitiveTendered, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withFirstInterestPeriod (String value) {
        return withFieldAndValue (Field.FirstInterestPeriod, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withFirstInterestPeriodAsNotNull () {
        return withFieldAndValue (Field.FirstInterestPeriod, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withFirstInterestPaymentDate (String value) {
        return withFieldAndValue (Field.FirstInterestPaymentDate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withFirstInterestPaymentDateAsNotNull () {
        return withFieldAndValue (Field.FirstInterestPaymentDate, NOT_NULL);
    }
    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withFirstInterestPaymentDateAsToday () {
        return withFieldAndValue (Field.FirstInterestPaymentDate, TODAY);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withFloatingRate (String value) {
        return withFieldAndValue (Field.FloatingRate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withFloatingRateAsNotNull () {
        return withFieldAndValue (Field.FloatingRate, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withFrnIndexDeterminationDate (String value) {
        return withFieldAndValue (Field.FrnIndexDeterminationDate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withFrnIndexDeterminationDateAsNotNull () {
        return withFieldAndValue (Field.FrnIndexDeterminationDate, NOT_NULL);
    }
    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withFrnIndexDeterminationDateAsToday () {
        return withFieldAndValue (Field.FrnIndexDeterminationDate, TODAY);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withFrnIndexDeterminationRate (String value) {
        return withFieldAndValue (Field.FrnIndexDeterminationRate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withFrnIndexDeterminationRateAsNotNull () {
        return withFieldAndValue (Field.FrnIndexDeterminationRate, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withHighDiscountRate (String value) {
        return withFieldAndValue (Field.HighDiscountRate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withHighDiscountRateAsNotNull () {
        return withFieldAndValue (Field.HighDiscountRate, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withHighInvestmentRate (String value) {
        return withFieldAndValue (Field.HighInvestmentRate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withHighInvestmentRateAsNotNull () {
        return withFieldAndValue (Field.HighInvestmentRate, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withHighPrice (String value) {
        return withFieldAndValue (Field.HighPrice, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withHighPriceAsNotNull () {
        return withFieldAndValue (Field.HighPrice, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withHighDiscountMargin (String value) {
        return withFieldAndValue (Field.HighDiscountMargin, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withHighDiscountMarginAsNotNull () {
        return withFieldAndValue (Field.HighDiscountMargin, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withHighYield (String value) {
        return withFieldAndValue (Field.HighYield, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withHighYieldAsNotNull () {
        return withFieldAndValue (Field.HighYield, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withIndexRatioOnIssueDate (String value) {
        return withFieldAndValue (Field.IndexRatioOnIssueDate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withIndexRatioOnIssueDateAsNotNull () {
        return withFieldAndValue (Field.IndexRatioOnIssueDate, NOT_NULL);
    }
    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withIndexRatioOnIssueDateAsToday () {
        return withFieldAndValue (Field.IndexRatioOnIssueDate, TODAY);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withIndirectBidderAccepted (String value) {
        return withFieldAndValue (Field.IndirectBidderAccepted, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withIndirectBidderAcceptedAsNotNull () {
        return withFieldAndValue (Field.IndirectBidderAccepted, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withIndirectBidderTendered (String value) {
        return withFieldAndValue (Field.IndirectBidderTendered, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withIndirectBidderTenderedAsNotNull () {
        return withFieldAndValue (Field.IndirectBidderTendered, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withInterestPaymentFrequency (String value) {
        return withFieldAndValue (Field.InterestPaymentFrequency, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withInterestPaymentFrequencyAsNotNull () {
        return withFieldAndValue (Field.InterestPaymentFrequency, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withLowDiscountRate (String value) {
        return withFieldAndValue (Field.LowDiscountRate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withLowDiscountRateAsNotNull () {
        return withFieldAndValue (Field.LowDiscountRate, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withLowInvestmentRate (String value) {
        return withFieldAndValue (Field.LowInvestmentRate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withLowInvestmentRateAsNotNull () {
        return withFieldAndValue (Field.LowInvestmentRate, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withLowPrice (String value) {
        return withFieldAndValue (Field.LowPrice, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withLowPriceAsNotNull () {
        return withFieldAndValue (Field.LowPrice, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withLowDiscountMargin (String value) {
        return withFieldAndValue (Field.LowDiscountMargin, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withLowDiscountMarginAsNotNull () {
        return withFieldAndValue (Field.LowDiscountMargin, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withLowYield (String value) {
        return withFieldAndValue (Field.LowYield, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withLowYieldAsNotNull () {
        return withFieldAndValue (Field.LowYield, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMaturingDate (String value) {
        return withFieldAndValue (Field.MaturingDate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMaturingDateAsNotNull () {
        return withFieldAndValue (Field.MaturingDate, NOT_NULL);
    }
    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMaturingDateAsToday () {
        return withFieldAndValue (Field.MaturingDate, TODAY);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMaximumCompetitiveAward (String value) {
        return withFieldAndValue (Field.MaximumCompetitiveAward, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMaximumCompetitiveAwardAsNotNull () {
        return withFieldAndValue (Field.MaximumCompetitiveAward, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMaximumNoncompetitiveAward (String value) {
        return withFieldAndValue (Field.MaximumNoncompetitiveAward, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMaximumNoncompetitiveAwardAsNotNull () {
        return withFieldAndValue (Field.MaximumNoncompetitiveAward, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMaximumSingleBid (String value) {
        return withFieldAndValue (Field.MaximumSingleBid, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMaximumSingleBidAsNotNull () {
        return withFieldAndValue (Field.MaximumSingleBid, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMinimumBidAmount (String value) {
        return withFieldAndValue (Field.MinimumBidAmount, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMinimumBidAmountAsNotNull () {
        return withFieldAndValue (Field.MinimumBidAmount, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMinimumStripAmount (String value) {
        return withFieldAndValue (Field.MinimumStripAmount, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMinimumStripAmountAsNotNull () {
        return withFieldAndValue (Field.MinimumStripAmount, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMinimumToIssue (String value) {
        return withFieldAndValue (Field.MinimumToIssue, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMinimumToIssueAsNotNull () {
        return withFieldAndValue (Field.MinimumToIssue, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMultiplesToBid (String value) {
        return withFieldAndValue (Field.MultiplesToBid, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMultiplesToBidAsNotNull () {
        return withFieldAndValue (Field.MultiplesToBid, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMultiplesToIssue (String value) {
        return withFieldAndValue (Field.MultiplesToIssue, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMultiplesToIssueAsNotNull () {
        return withFieldAndValue (Field.MultiplesToIssue, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withNlpExclusionAmount (String value) {
        return withFieldAndValue (Field.NlpExclusionAmount, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withNlpExclusionAmountAsNotNull () {
        return withFieldAndValue (Field.NlpExclusionAmount, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withNlpReportingThreshold (String value) {
        return withFieldAndValue (Field.NlpReportingThreshold, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withNlpReportingThresholdAsNotNull () {
        return withFieldAndValue (Field.NlpReportingThreshold, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withNoncompetitiveAccepted (String value) {
        return withFieldAndValue (Field.NoncompetitiveAccepted, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withNoncompetitiveAcceptedAsNotNull () {
        return withFieldAndValue (Field.NoncompetitiveAccepted, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withNoncompetitiveTendersAccepted (String value) {
        return withFieldAndValue (Field.NoncompetitiveTendersAccepted, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withNoncompetitiveTendersAcceptedAsNotNull () {
        return withFieldAndValue (Field.NoncompetitiveTendersAccepted, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withOfferingAmount (String value) {
        return withFieldAndValue (Field.OfferingAmount, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withOfferingAmountAsNotNull () {
        return withFieldAndValue (Field.OfferingAmount, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withOriginalCusip (String value) {
        return withFieldAndValue (Field.OriginalCusip, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withOriginalCusipAsNotNull () {
        return withFieldAndValue (Field.OriginalCusip, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withOriginalDatedDate (String value) {
        return withFieldAndValue (Field.OriginalDatedDate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withOriginalDatedDateAsNotNull () {
        return withFieldAndValue (Field.OriginalDatedDate, NOT_NULL);
    }
    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withOriginalDatedDateAsToday () {
        return withFieldAndValue (Field.OriginalDatedDate, TODAY);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withOriginalIssueDate (String value) {
        return withFieldAndValue (Field.OriginalIssueDate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withOriginalIssueDateAsNotNull () {
        return withFieldAndValue (Field.OriginalIssueDate, NOT_NULL);
    }
    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withOriginalIssueDateAsToday () {
        return withFieldAndValue (Field.OriginalIssueDate, TODAY);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withOriginalSecurityTerm (String value) {
        return withFieldAndValue (Field.OriginalSecurityTerm, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withOriginalSecurityTermAsNotNull () {
        return withFieldAndValue (Field.OriginalSecurityTerm, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withPdfFilenameAnnouncement (String value) {
        return withFieldAndValue (Field.PdfFilenameAnnouncement, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withPdfFilenameAnnouncementAsNotNull () {
        return withFieldAndValue (Field.PdfFilenameAnnouncement, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withPdfFilenameCompetitiveResults (String value) {
        return withFieldAndValue (Field.PdfFilenameCompetitiveResults, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withPdfFilenameCompetitiveResultsAsNotNull () {
        return withFieldAndValue (Field.PdfFilenameCompetitiveResults, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withPdfFilenameNoncompetitiveResults (String value) {
        return withFieldAndValue (Field.PdfFilenameNoncompetitiveResults, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withPdfFilenameNoncompetitiveResultsAsNotNull () {
        return withFieldAndValue (Field.PdfFilenameNoncompetitiveResults, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withPdfFilenameSpecialAnnouncement (String value) {
        return withFieldAndValue (Field.PdfFilenameSpecialAnnouncement, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withPdfFilenameSpecialAnnouncementAsNotNull () {
        return withFieldAndValue (Field.PdfFilenameSpecialAnnouncement, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withPricePer100 (String value) {
        return withFieldAndValue (Field.PricePer100, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withPricePer100AsNotNull () {
        return withFieldAndValue (Field.PricePer100, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withPrimaryDealerAccepted (String value) {
        return withFieldAndValue (Field.PrimaryDealerAccepted, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withPrimaryDealerAcceptedAsNotNull () {
        return withFieldAndValue (Field.PrimaryDealerAccepted, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withPrimaryDealerTendered (String value) {
        return withFieldAndValue (Field.PrimaryDealerTendered, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withPrimaryDealerTenderedAsNotNull () {
        return withFieldAndValue (Field.PrimaryDealerTendered, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withReopening (String value) {
        return withFieldAndValue (Field.Reopening, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withReopeningAsNotNull () {
        return withFieldAndValue (Field.Reopening, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withSecurityTermDayMonth (String value) {
        return withFieldAndValue (Field.SecurityTermDayMonth, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withSecurityTermDayMonthAsNotNull () {
        return withFieldAndValue (Field.SecurityTermDayMonth, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withSecurityTermWeekYear (String value) {
        return withFieldAndValue (Field.SecurityTermWeekYear, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withSecurityTermWeekYearAsNotNull () {
        return withFieldAndValue (Field.SecurityTermWeekYear, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withSeries (String value) {
        return withFieldAndValue (Field.Series, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withSeriesAsNotNull () {
        return withFieldAndValue (Field.Series, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withSomaAccepted (String value) {
        return withFieldAndValue (Field.SomaAccepted, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withSomaAcceptedAsNotNull () {
        return withFieldAndValue (Field.SomaAccepted, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withSomaHoldings (String value) {
        return withFieldAndValue (Field.SomaHoldings, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withSomaHoldingsAsNotNull () {
        return withFieldAndValue (Field.SomaHoldings, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withSomaIncluded (String value) {
        return withFieldAndValue (Field.SomaIncluded, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withSomaIncludedAsNotNull () {
        return withFieldAndValue (Field.SomaIncluded, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withSomaTendered (String value) {
        return withFieldAndValue (Field.SomaTendered, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withSomaTenderedAsNotNull () {
        return withFieldAndValue (Field.SomaTendered, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withSpread (String value) {
        return withFieldAndValue (Field.Spread, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withSpreadAsNotNull () {
        return withFieldAndValue (Field.Spread, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withStandardInterestPaymentPer1000 (String value) {
        return withFieldAndValue (Field.StandardInterestPaymentPer1000, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withStandardInterestPaymentPer1000AsNotNull () {
        return withFieldAndValue (Field.StandardInterestPaymentPer1000, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withStrippable (String value) {
        return withFieldAndValue (Field.Strippable, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withStrippableAsNotNull () {
        return withFieldAndValue (Field.Strippable, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withTerm (String value) {
        return withFieldAndValue (Field.Term, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withTermAsNotNull () {
        return withFieldAndValue (Field.Term, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withTiinConversionFactorPer1000 (String value) {
        return withFieldAndValue (Field.TiinConversionFactorPer1000, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withTiinConversionFactorPer1000AsNotNull () {
        return withFieldAndValue (Field.TiinConversionFactorPer1000, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withTips (String value) {
        return withFieldAndValue (Field.Tips, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withTipsAsNotNull () {
        return withFieldAndValue (Field.Tips, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withTotalAccepted (String value) {
        return withFieldAndValue (Field.TotalAccepted, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withTotalAcceptedAsNotNull () {
        return withFieldAndValue (Field.TotalAccepted, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withTotalTendered (String value) {
        return withFieldAndValue (Field.TotalTendered, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withTotalTenderedAsNotNull () {
        return withFieldAndValue (Field.TotalTendered, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withTreasuryDirectAccepted (String value) {
        return withFieldAndValue (Field.TreasuryDirectAccepted, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withTreasuryDirectAcceptedAsNotNull () {
        return withFieldAndValue (Field.TreasuryDirectAccepted, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withTreasuryDirectTendersAccepted (String value) {
        return withFieldAndValue (Field.TreasuryDirectTendersAccepted, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withTreasuryDirectTendersAcceptedAsNotNull () {
        return withFieldAndValue (Field.TreasuryDirectTendersAccepted, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withType (String value) {
        return withFieldAndValue (Field.Type, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withTypeAsNotNull () {
        return withFieldAndValue (Field.Type, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withUnadjustedAccruedInterestPer1000 (String value) {
        return withFieldAndValue (Field.UnadjustedAccruedInterestPer1000, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withUnadjustedAccruedInterestPer1000AsNotNull () {
        return withFieldAndValue (Field.UnadjustedAccruedInterestPer1000, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withUnadjustedPrice (String value) {
        return withFieldAndValue (Field.UnadjustedPrice, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withUnadjustedPriceAsNotNull () {
        return withFieldAndValue (Field.UnadjustedPrice, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withUpdatedTimestamp (String value) {
        return withFieldAndValue (Field.UpdatedTimestamp, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withUpdatedTimestampAsNotNull () {
        return withFieldAndValue (Field.UpdatedTimestamp, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withXmlFilenameAnnouncement (String value) {
        return withFieldAndValue (Field.XmlFilenameAnnouncement, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withXmlFilenameAnnouncementAsNotNull () {
        return withFieldAndValue (Field.XmlFilenameAnnouncement, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withXmlFilenameSpecialAnnouncement (String value) {
        return withFieldAndValue (Field.XmlFilenameSpecialAnnouncement, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withXmlFilenameSpecialAnnouncementAsNotNull () {
        return withFieldAndValue (Field.XmlFilenameSpecialAnnouncement, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAuctionDateYear (String value) {
        return withFieldAndValue (Field.AuctionDateYear, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAuctionDateYearAsNotNull () {
        return withFieldAndValue (Field.AuctionDateYear, NOT_NULL);
    }

    // Autogenerated methods ends.

    public QueryBuilder debt (String yyyy, String mm, String dd) {

        NP_WS();
        extendPathWith(DEBT);
        extendPathWith(yyyy);
        extendPathWith(mm);
        extendPathWith(dd);

        return this;
    }

    public QueryBuilder debt () {

        NP_WS();
        extendPathWith(DEBT);

        return this;
    }

    public QueryBuilder current () {

        extendPathWith(CURRENT);

        return this;
    }

    public QueryBuilder search () {

        extendPathWith(SEARCH);

        return this;
    }

    /**
     * 
     * @param date MM/DD/YYYY String mm, String dd, String yyyy
     * @return
     */
    public QueryBuilder withStartDate (String startDate) {

        addParameter(START_DATE, startDate);

        return this;
    }

    /**
     * 
     * @param date MM/DD/YYYY String mm, String dd, String yyyy
     * @return
     */
    public QueryBuilder withEndDate (String endDate) {

        addParameter(END_DATE, endDate);

        return this;
    }

//    public QueryBuilder withType (String type) {
//
//        addParameter(TYPE, type);
//
//        return this;
//    }

    public QueryBuilder withTypeAsBill () {

        addParameter(TYPE, BILL);

        return this;
    }

    public QueryBuilder withTypeAsNote () {

        addParameter(TYPE, NOTE);

        return this;
    }

    public QueryBuilder withTypeAsBond () {

        addParameter(TYPE, BOND);

        return this;
    }

    public QueryBuilder withTypeAsCMB () {

        addParameter(TYPE, CMB);

        return this;
    }

    public QueryBuilder withTypeAsTIPS () {

        addParameter(TYPE, TIPS);

        return this;
    }

    public QueryBuilder withTypeAsFRN () {

        addParameter(TYPE, FRN);

        return this;
    }

    @Override
    protected String getKey() {
        return getEscapedURI();
    }

    @Override
    protected <T> T doExecute(Class<T> type) {

        ResponseExtractor<? extends SerializableBean<?>> responseExtractor = null;

        if (Securities.class.equals(type))
            responseExtractor = securitiesExtractor;
        else if (Debts.class.equals(type))
            responseExtractor = debtsExtractor;
        else
            throw new UnsupportedTypeException (type);

        addParameter(FORMAT, JSON);

        log.info("responseExtractor: " + responseExtractor + ", escapedURI: " + getEscapedURI());

        T result = (T) getRestTemplate()
            .execute(getEscapedURI(), HttpMethod.GET, (RequestCallback) null, responseExtractor);

        getCache().put(getEscapedURI(), result);

        return result;
    }

    public Securities doGetAsSecurities () {
        return doGet(Securities.class);
    }

    public Debts doGetAsDebts () {
        return doGet(Debts.class);
    }
}
