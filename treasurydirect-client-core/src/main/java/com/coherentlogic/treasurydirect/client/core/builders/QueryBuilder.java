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
        "***                                        Version 0.8.6-RELEASE                                         ***",
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
        accruedInterestPer1000,
        accruedInterestPer100,
        adjustedAccruedInterestPer1000,
        adjustedPrice,
        allocationPercentage,
        allocationPercentageDecimals,
        announcedCusip,
        auctionFormat,
        averageMedianDiscountRate,
        averageMedianInvestmentRate,
        averageMedianPrice,
        averageMedianDiscountMargin,
        averageMedianYield,
        backDated,
        backDatedDate,
        bidToCoverRatio,
        callDate,
        callable,
        calledDate,
        cashManagementBillCMB,
        closingTimeCompetitive,
        closingTimeNoncompetitive,
        competitiveAccepted,
        competitiveBidDecimals,
        competitiveTendered,
        competitiveTendersAccepted,
        corpusCusip,
        cpiBaseReferencePeriod,
        currentlyOutstanding,
        directBidderAccepted,
        directBidderTendered,
        estimatedAmountOfPubliclyHeldMaturingSecuritiesByType,
        fimaIncluded,
        fimaNoncompetitiveAccepted,
        fimaNoncompetitiveTendered,
        firstInterestPeriod,
        firstInterestPaymentDate,
        floatingRate,
        frnIndexDeterminationDate,
        frnIndexDeterminationRate,
        highDiscountRate,
        highInvestmentRate,
        highPrice,
        highDiscountMargin,
        highYield,
        indexRatioOnIssueDate,
        indirectBidderAccepted,
        indirectBidderTendered,
        interestPaymentFrequency,
        lowDiscountRate,
        lowInvestmentRate,
        lowPrice,
        lowDiscountMargin,
        lowYield,
        maturingDate,
        maximumCompetitiveAward,
        maximumNoncompetitiveAward,
        maximumSingleBid,
        minimumBidAmount,
        minimumStripAmount,
        minimumToIssue,
        multiplesToBid,
        multiplesToIssue,
        nlpExclusionAmount,
        nlpReportingThreshold,
        noncompetitiveAccepted,
        noncompetitiveTendersAccepted,
        offeringAmount,
        originalCusip,
        originalDatedDate,
        originalIssueDate,
        originalSecurityTerm,
        pdfFilenameAnnouncement,
        pdfFilenameCompetitiveResults,
        pdfFilenameNoncompetitiveResults,
        pdfFilenameSpecialAnnouncement,
        pricePer100,
        primaryDealerAccepted,
        primaryDealerTendered,
        reopening,
        securityTermDayMonth,
        securityTermWeekYear,
        series,
        somaAccepted,
        somaHoldings,
        somaIncluded,
        somaTendered,
        spread,
        standardInterestPaymentPer1000,
        strippable,
        term,
        tiinConversionFactorPer1000,
        tips,
        totalAccepted,
        totalTendered,
        treasuryDirectAccepted,
        treasuryDirectTendersAccepted,
        type,
        unadjustedAccruedInterestPer1000,
        unadjustedPrice,
        updatedTimestamp,
        xmlFilenameAnnouncement,
        xmlFilenameSpecialAnnouncement,
        auctionDateYear
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
        return withFieldAndValue (Field.accruedInterestPer1000, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAccruedInterestPer1000AsNotNull () {
        return withFieldAndValue (Field.accruedInterestPer1000, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAccruedInterestPer100 (String value) {
        return withFieldAndValue (Field.accruedInterestPer100, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAccruedInterestPer100AsNotNull () {
        return withFieldAndValue (Field.accruedInterestPer100, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAdjustedAccruedInterestPer1000 (String value) {
        return withFieldAndValue (Field.adjustedAccruedInterestPer1000, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAdjustedAccruedInterestPer1000AsNotNull () {
        return withFieldAndValue (Field.adjustedAccruedInterestPer1000, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAdjustedPrice (String value) {
        return withFieldAndValue (Field.adjustedPrice, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAdjustedPriceAsNotNull () {
        return withFieldAndValue (Field.adjustedPrice, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAllocationPercentage (String value) {
        return withFieldAndValue (Field.allocationPercentage, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAllocationPercentageAsNotNull () {
        return withFieldAndValue (Field.allocationPercentage, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAllocationPercentageDecimals (String value) {
        return withFieldAndValue (Field.allocationPercentageDecimals, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAllocationPercentageDecimalsAsNotNull () {
        return withFieldAndValue (Field.allocationPercentageDecimals, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAnnouncedCusip (String value) {
        return withFieldAndValue (Field.announcedCusip, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAnnouncedCusipAsNotNull () {
        return withFieldAndValue (Field.announcedCusip, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAuctionFormat (String value) {
        return withFieldAndValue (Field.auctionFormat, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAuctionFormatAsNotNull () {
        return withFieldAndValue (Field.auctionFormat, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAverageMedianDiscountRate (String value) {
        return withFieldAndValue (Field.averageMedianDiscountRate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAverageMedianDiscountRateAsNotNull () {
        return withFieldAndValue (Field.averageMedianDiscountRate, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAverageMedianInvestmentRate (String value) {
        return withFieldAndValue (Field.averageMedianInvestmentRate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAverageMedianInvestmentRateAsNotNull () {
        return withFieldAndValue (Field.averageMedianInvestmentRate, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAverageMedianPrice (String value) {
        return withFieldAndValue (Field.averageMedianPrice, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAverageMedianPriceAsNotNull () {
        return withFieldAndValue (Field.averageMedianPrice, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAverageMedianDiscountMargin (String value) {
        return withFieldAndValue (Field.averageMedianDiscountMargin, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAverageMedianDiscountMarginAsNotNull () {
        return withFieldAndValue (Field.averageMedianDiscountMargin, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAverageMedianYield (String value) {
        return withFieldAndValue (Field.averageMedianYield, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAverageMedianYieldAsNotNull () {
        return withFieldAndValue (Field.averageMedianYield, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withBackDated (String value) {
        return withFieldAndValue (Field.backDated, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withBackDatedAsNotNull () {
        return withFieldAndValue (Field.backDated, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withBackDatedDate (String value) {
        return withFieldAndValue (Field.backDatedDate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withBackDatedDateAsNotNull () {
        return withFieldAndValue (Field.backDatedDate, NOT_NULL);
    }
    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withBackDatedDateAsToday () {
        return withFieldAndValue (Field.backDatedDate, TODAY);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withBidToCoverRatio (String value) {
        return withFieldAndValue (Field.bidToCoverRatio, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withBidToCoverRatioAsNotNull () {
        return withFieldAndValue (Field.bidToCoverRatio, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCallDate (String value) {
        return withFieldAndValue (Field.callDate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCallDateAsNotNull () {
        return withFieldAndValue (Field.callDate, NOT_NULL);
    }
    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCallDateAsToday () {
        return withFieldAndValue (Field.callDate, TODAY);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCallable (String value) {
        return withFieldAndValue (Field.callable, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCallableAsNotNull () {
        return withFieldAndValue (Field.callable, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCalledDate (String value) {
        return withFieldAndValue (Field.calledDate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCalledDateAsNotNull () {
        return withFieldAndValue (Field.calledDate, NOT_NULL);
    }
    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCalledDateAsToday () {
        return withFieldAndValue (Field.calledDate, TODAY);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCashManagementBillCMB (String value) {
        return withFieldAndValue (Field.cashManagementBillCMB, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCashManagementBillCMBAsNotNull () {
        return withFieldAndValue (Field.cashManagementBillCMB, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withClosingTimeCompetitive (String value) {
        return withFieldAndValue (Field.closingTimeCompetitive, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withClosingTimeCompetitiveAsNotNull () {
        return withFieldAndValue (Field.closingTimeCompetitive, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withClosingTimeNoncompetitive (String value) {
        return withFieldAndValue (Field.closingTimeNoncompetitive, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withClosingTimeNoncompetitiveAsNotNull () {
        return withFieldAndValue (Field.closingTimeNoncompetitive, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCompetitiveAccepted (String value) {
        return withFieldAndValue (Field.competitiveAccepted, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCompetitiveAcceptedAsNotNull () {
        return withFieldAndValue (Field.competitiveAccepted, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCompetitiveBidDecimals (String value) {
        return withFieldAndValue (Field.competitiveBidDecimals, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCompetitiveBidDecimalsAsNotNull () {
        return withFieldAndValue (Field.competitiveBidDecimals, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCompetitiveTendered (String value) {
        return withFieldAndValue (Field.competitiveTendered, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCompetitiveTenderedAsNotNull () {
        return withFieldAndValue (Field.competitiveTendered, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCompetitiveTendersAccepted (String value) {
        return withFieldAndValue (Field.competitiveTendersAccepted, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCompetitiveTendersAcceptedAsNotNull () {
        return withFieldAndValue (Field.competitiveTendersAccepted, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCorpusCusip (String value) {
        return withFieldAndValue (Field.corpusCusip, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCorpusCusipAsNotNull () {
        return withFieldAndValue (Field.corpusCusip, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCpiBaseReferencePeriod (String value) {
        return withFieldAndValue (Field.cpiBaseReferencePeriod, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCpiBaseReferencePeriodAsNotNull () {
        return withFieldAndValue (Field.cpiBaseReferencePeriod, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCurrentlyOutstanding (String value) {
        return withFieldAndValue (Field.currentlyOutstanding, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withCurrentlyOutstandingAsNotNull () {
        return withFieldAndValue (Field.currentlyOutstanding, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withDirectBidderAccepted (String value) {
        return withFieldAndValue (Field.directBidderAccepted, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withDirectBidderAcceptedAsNotNull () {
        return withFieldAndValue (Field.directBidderAccepted, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withDirectBidderTendered (String value) {
        return withFieldAndValue (Field.directBidderTendered, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withDirectBidderTenderedAsNotNull () {
        return withFieldAndValue (Field.directBidderTendered, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withEstimatedAmountOfPubliclyHeldMaturingSecuritiesByType (String value) {
        return withFieldAndValue (Field.estimatedAmountOfPubliclyHeldMaturingSecuritiesByType, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withEstimatedAmountOfPubliclyHeldMaturingSecuritiesByTypeAsNotNull () {
        return withFieldAndValue (Field.estimatedAmountOfPubliclyHeldMaturingSecuritiesByType, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withFimaIncluded (String value) {
        return withFieldAndValue (Field.fimaIncluded, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withFimaIncludedAsNotNull () {
        return withFieldAndValue (Field.fimaIncluded, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withFimaNoncompetitiveAccepted (String value) {
        return withFieldAndValue (Field.fimaNoncompetitiveAccepted, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withFimaNoncompetitiveAcceptedAsNotNull () {
        return withFieldAndValue (Field.fimaNoncompetitiveAccepted, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withFimaNoncompetitiveTendered (String value) {
        return withFieldAndValue (Field.fimaNoncompetitiveTendered, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withFimaNoncompetitiveTenderedAsNotNull () {
        return withFieldAndValue (Field.fimaNoncompetitiveTendered, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withFirstInterestPeriod (String value) {
        return withFieldAndValue (Field.firstInterestPeriod, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withFirstInterestPeriodAsNotNull () {
        return withFieldAndValue (Field.firstInterestPeriod, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withFirstInterestPaymentDate (String value) {
        return withFieldAndValue (Field.firstInterestPaymentDate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withFirstInterestPaymentDateAsNotNull () {
        return withFieldAndValue (Field.firstInterestPaymentDate, NOT_NULL);
    }
    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withFirstInterestPaymentDateAsToday () {
        return withFieldAndValue (Field.firstInterestPaymentDate, TODAY);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withFloatingRate (String value) {
        return withFieldAndValue (Field.floatingRate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withFloatingRateAsNotNull () {
        return withFieldAndValue (Field.floatingRate, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withFrnIndexDeterminationDate (String value) {
        return withFieldAndValue (Field.frnIndexDeterminationDate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withFrnIndexDeterminationDateAsNotNull () {
        return withFieldAndValue (Field.frnIndexDeterminationDate, NOT_NULL);
    }
    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withFrnIndexDeterminationDateAsToday () {
        return withFieldAndValue (Field.frnIndexDeterminationDate, TODAY);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withFrnIndexDeterminationRate (String value) {
        return withFieldAndValue (Field.frnIndexDeterminationRate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withFrnIndexDeterminationRateAsNotNull () {
        return withFieldAndValue (Field.frnIndexDeterminationRate, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withHighDiscountRate (String value) {
        return withFieldAndValue (Field.highDiscountRate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withHighDiscountRateAsNotNull () {
        return withFieldAndValue (Field.highDiscountRate, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withHighInvestmentRate (String value) {
        return withFieldAndValue (Field.highInvestmentRate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withHighInvestmentRateAsNotNull () {
        return withFieldAndValue (Field.highInvestmentRate, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withHighPrice (String value) {
        return withFieldAndValue (Field.highPrice, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withHighPriceAsNotNull () {
        return withFieldAndValue (Field.highPrice, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withHighDiscountMargin (String value) {
        return withFieldAndValue (Field.highDiscountMargin, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withHighDiscountMarginAsNotNull () {
        return withFieldAndValue (Field.highDiscountMargin, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withHighYield (String value) {
        return withFieldAndValue (Field.highYield, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withHighYieldAsNotNull () {
        return withFieldAndValue (Field.highYield, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withIndexRatioOnIssueDate (String value) {
        return withFieldAndValue (Field.indexRatioOnIssueDate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withIndexRatioOnIssueDateAsNotNull () {
        return withFieldAndValue (Field.indexRatioOnIssueDate, NOT_NULL);
    }
    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withIndexRatioOnIssueDateAsToday () {
        return withFieldAndValue (Field.indexRatioOnIssueDate, TODAY);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withIndirectBidderAccepted (String value) {
        return withFieldAndValue (Field.indirectBidderAccepted, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withIndirectBidderAcceptedAsNotNull () {
        return withFieldAndValue (Field.indirectBidderAccepted, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withIndirectBidderTendered (String value) {
        return withFieldAndValue (Field.indirectBidderTendered, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withIndirectBidderTenderedAsNotNull () {
        return withFieldAndValue (Field.indirectBidderTendered, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withInterestPaymentFrequency (String value) {
        return withFieldAndValue (Field.interestPaymentFrequency, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withInterestPaymentFrequencyAsNotNull () {
        return withFieldAndValue (Field.interestPaymentFrequency, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withLowDiscountRate (String value) {
        return withFieldAndValue (Field.lowDiscountRate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withLowDiscountRateAsNotNull () {
        return withFieldAndValue (Field.lowDiscountRate, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withLowInvestmentRate (String value) {
        return withFieldAndValue (Field.lowInvestmentRate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withLowInvestmentRateAsNotNull () {
        return withFieldAndValue (Field.lowInvestmentRate, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withLowPrice (String value) {
        return withFieldAndValue (Field.lowPrice, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withLowPriceAsNotNull () {
        return withFieldAndValue (Field.lowPrice, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withLowDiscountMargin (String value) {
        return withFieldAndValue (Field.lowDiscountMargin, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withLowDiscountMarginAsNotNull () {
        return withFieldAndValue (Field.lowDiscountMargin, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withLowYield (String value) {
        return withFieldAndValue (Field.lowYield, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withLowYieldAsNotNull () {
        return withFieldAndValue (Field.lowYield, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMaturingDate (String value) {
        return withFieldAndValue (Field.maturingDate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMaturingDateAsNotNull () {
        return withFieldAndValue (Field.maturingDate, NOT_NULL);
    }
    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMaturingDateAsToday () {
        return withFieldAndValue (Field.maturingDate, TODAY);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMaximumCompetitiveAward (String value) {
        return withFieldAndValue (Field.maximumCompetitiveAward, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMaximumCompetitiveAwardAsNotNull () {
        return withFieldAndValue (Field.maximumCompetitiveAward, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMaximumNoncompetitiveAward (String value) {
        return withFieldAndValue (Field.maximumNoncompetitiveAward, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMaximumNoncompetitiveAwardAsNotNull () {
        return withFieldAndValue (Field.maximumNoncompetitiveAward, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMaximumSingleBid (String value) {
        return withFieldAndValue (Field.maximumSingleBid, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMaximumSingleBidAsNotNull () {
        return withFieldAndValue (Field.maximumSingleBid, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMinimumBidAmount (String value) {
        return withFieldAndValue (Field.minimumBidAmount, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMinimumBidAmountAsNotNull () {
        return withFieldAndValue (Field.minimumBidAmount, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMinimumStripAmount (String value) {
        return withFieldAndValue (Field.minimumStripAmount, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMinimumStripAmountAsNotNull () {
        return withFieldAndValue (Field.minimumStripAmount, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMinimumToIssue (String value) {
        return withFieldAndValue (Field.minimumToIssue, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMinimumToIssueAsNotNull () {
        return withFieldAndValue (Field.minimumToIssue, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMultiplesToBid (String value) {
        return withFieldAndValue (Field.multiplesToBid, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMultiplesToBidAsNotNull () {
        return withFieldAndValue (Field.multiplesToBid, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMultiplesToIssue (String value) {
        return withFieldAndValue (Field.multiplesToIssue, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withMultiplesToIssueAsNotNull () {
        return withFieldAndValue (Field.multiplesToIssue, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withNlpExclusionAmount (String value) {
        return withFieldAndValue (Field.nlpExclusionAmount, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withNlpExclusionAmountAsNotNull () {
        return withFieldAndValue (Field.nlpExclusionAmount, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withNlpReportingThreshold (String value) {
        return withFieldAndValue (Field.nlpReportingThreshold, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withNlpReportingThresholdAsNotNull () {
        return withFieldAndValue (Field.nlpReportingThreshold, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withNoncompetitiveAccepted (String value) {
        return withFieldAndValue (Field.noncompetitiveAccepted, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withNoncompetitiveAcceptedAsNotNull () {
        return withFieldAndValue (Field.noncompetitiveAccepted, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withNoncompetitiveTendersAccepted (String value) {
        return withFieldAndValue (Field.noncompetitiveTendersAccepted, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withNoncompetitiveTendersAcceptedAsNotNull () {
        return withFieldAndValue (Field.noncompetitiveTendersAccepted, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withOfferingAmount (String value) {
        return withFieldAndValue (Field.offeringAmount, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withOfferingAmountAsNotNull () {
        return withFieldAndValue (Field.offeringAmount, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withOriginalCusip (String value) {
        return withFieldAndValue (Field.originalCusip, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withOriginalCusipAsNotNull () {
        return withFieldAndValue (Field.originalCusip, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withOriginalDatedDate (String value) {
        return withFieldAndValue (Field.originalDatedDate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withOriginalDatedDateAsNotNull () {
        return withFieldAndValue (Field.originalDatedDate, NOT_NULL);
    }
    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withOriginalDatedDateAsToday () {
        return withFieldAndValue (Field.originalDatedDate, TODAY);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withOriginalIssueDate (String value) {
        return withFieldAndValue (Field.originalIssueDate, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withOriginalIssueDateAsNotNull () {
        return withFieldAndValue (Field.originalIssueDate, NOT_NULL);
    }
    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withOriginalIssueDateAsToday () {
        return withFieldAndValue (Field.originalIssueDate, TODAY);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withOriginalSecurityTerm (String value) {
        return withFieldAndValue (Field.originalSecurityTerm, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withOriginalSecurityTermAsNotNull () {
        return withFieldAndValue (Field.originalSecurityTerm, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withPdfFilenameAnnouncement (String value) {
        return withFieldAndValue (Field.pdfFilenameAnnouncement, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withPdfFilenameAnnouncementAsNotNull () {
        return withFieldAndValue (Field.pdfFilenameAnnouncement, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withPdfFilenameCompetitiveResults (String value) {
        return withFieldAndValue (Field.pdfFilenameCompetitiveResults, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withPdfFilenameCompetitiveResultsAsNotNull () {
        return withFieldAndValue (Field.pdfFilenameCompetitiveResults, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withPdfFilenameNoncompetitiveResults (String value) {
        return withFieldAndValue (Field.pdfFilenameNoncompetitiveResults, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withPdfFilenameNoncompetitiveResultsAsNotNull () {
        return withFieldAndValue (Field.pdfFilenameNoncompetitiveResults, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withPdfFilenameSpecialAnnouncement (String value) {
        return withFieldAndValue (Field.pdfFilenameSpecialAnnouncement, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withPdfFilenameSpecialAnnouncementAsNotNull () {
        return withFieldAndValue (Field.pdfFilenameSpecialAnnouncement, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withPricePer100 (String value) {
        return withFieldAndValue (Field.pricePer100, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withPricePer100AsNotNull () {
        return withFieldAndValue (Field.pricePer100, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withPrimaryDealerAccepted (String value) {
        return withFieldAndValue (Field.primaryDealerAccepted, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withPrimaryDealerAcceptedAsNotNull () {
        return withFieldAndValue (Field.primaryDealerAccepted, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withPrimaryDealerTendered (String value) {
        return withFieldAndValue (Field.primaryDealerTendered, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withPrimaryDealerTenderedAsNotNull () {
        return withFieldAndValue (Field.primaryDealerTendered, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withReopening (String value) {
        return withFieldAndValue (Field.reopening, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withReopeningAsNotNull () {
        return withFieldAndValue (Field.reopening, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withSecurityTermDayMonth (String value) {
        return withFieldAndValue (Field.securityTermDayMonth, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withSecurityTermDayMonthAsNotNull () {
        return withFieldAndValue (Field.securityTermDayMonth, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withSecurityTermWeekYear (String value) {
        return withFieldAndValue (Field.securityTermWeekYear, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withSecurityTermWeekYearAsNotNull () {
        return withFieldAndValue (Field.securityTermWeekYear, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withSeries (String value) {
        return withFieldAndValue (Field.series, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withSeriesAsNotNull () {
        return withFieldAndValue (Field.series, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withSomaAccepted (String value) {
        return withFieldAndValue (Field.somaAccepted, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withSomaAcceptedAsNotNull () {
        return withFieldAndValue (Field.somaAccepted, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withSomaHoldings (String value) {
        return withFieldAndValue (Field.somaHoldings, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withSomaHoldingsAsNotNull () {
        return withFieldAndValue (Field.somaHoldings, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withSomaIncluded (String value) {
        return withFieldAndValue (Field.somaIncluded, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withSomaIncludedAsNotNull () {
        return withFieldAndValue (Field.somaIncluded, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withSomaTendered (String value) {
        return withFieldAndValue (Field.somaTendered, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withSomaTenderedAsNotNull () {
        return withFieldAndValue (Field.somaTendered, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withSpread (String value) {
        return withFieldAndValue (Field.spread, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withSpreadAsNotNull () {
        return withFieldAndValue (Field.spread, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withStandardInterestPaymentPer1000 (String value) {
        return withFieldAndValue (Field.standardInterestPaymentPer1000, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withStandardInterestPaymentPer1000AsNotNull () {
        return withFieldAndValue (Field.standardInterestPaymentPer1000, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withStrippable (String value) {
        return withFieldAndValue (Field.strippable, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withStrippableAsNotNull () {
        return withFieldAndValue (Field.strippable, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withTerm (String value) {
        return withFieldAndValue (Field.term, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withTermAsNotNull () {
        return withFieldAndValue (Field.term, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withTiinConversionFactorPer1000 (String value) {
        return withFieldAndValue (Field.tiinConversionFactorPer1000, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withTiinConversionFactorPer1000AsNotNull () {
        return withFieldAndValue (Field.tiinConversionFactorPer1000, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withTips (String value) {
        return withFieldAndValue (Field.tips, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withTipsAsNotNull () {
        return withFieldAndValue (Field.tips, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withTotalAccepted (String value) {
        return withFieldAndValue (Field.totalAccepted, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withTotalAcceptedAsNotNull () {
        return withFieldAndValue (Field.totalAccepted, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withTotalTendered (String value) {
        return withFieldAndValue (Field.totalTendered, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withTotalTenderedAsNotNull () {
        return withFieldAndValue (Field.totalTendered, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withTreasuryDirectAccepted (String value) {
        return withFieldAndValue (Field.treasuryDirectAccepted, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withTreasuryDirectAcceptedAsNotNull () {
        return withFieldAndValue (Field.treasuryDirectAccepted, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withTreasuryDirectTendersAccepted (String value) {
        return withFieldAndValue (Field.treasuryDirectTendersAccepted, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withTreasuryDirectTendersAcceptedAsNotNull () {
        return withFieldAndValue (Field.treasuryDirectTendersAccepted, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withType (String value) {
        return withFieldAndValue (Field.type, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withTypeAsNotNull () {
        return withFieldAndValue (Field.type, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withUnadjustedAccruedInterestPer1000 (String value) {
        return withFieldAndValue (Field.unadjustedAccruedInterestPer1000, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withUnadjustedAccruedInterestPer1000AsNotNull () {
        return withFieldAndValue (Field.unadjustedAccruedInterestPer1000, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withUnadjustedPrice (String value) {
        return withFieldAndValue (Field.unadjustedPrice, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withUnadjustedPriceAsNotNull () {
        return withFieldAndValue (Field.unadjustedPrice, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withUpdatedTimestamp (String value) {
        return withFieldAndValue (Field.updatedTimestamp, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withUpdatedTimestampAsNotNull () {
        return withFieldAndValue (Field.updatedTimestamp, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withXmlFilenameAnnouncement (String value) {
        return withFieldAndValue (Field.xmlFilenameAnnouncement, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withXmlFilenameAnnouncementAsNotNull () {
        return withFieldAndValue (Field.xmlFilenameAnnouncement, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withXmlFilenameSpecialAnnouncement (String value) {
        return withFieldAndValue (Field.xmlFilenameSpecialAnnouncement, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withXmlFilenameSpecialAnnouncementAsNotNull () {
        return withFieldAndValue (Field.xmlFilenameSpecialAnnouncement, NOT_NULL);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAuctionDateYear (String value) {
        return withFieldAndValue (Field.auctionDateYear, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder withAuctionDateYearAsNotNull () {
        return withFieldAndValue (Field.auctionDateYear, NOT_NULL);
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
