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
import com.coherentlogic.coherent.data.adapter.core.util.WelcomeMessage;
import com.coherentlogic.coherent.data.model.core.util.Utils;
import com.coherentlogic.treasurydirect.client.core.domain.Securities;
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

    public static final String DEFAULT_URI = "http://www.treasurydirect.gov/",
        TA_WS = "TA_WS",
        NP_WS = "NP_WS",
        SECURITIES = "securities",
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
        FRN = "FRN";

    static final DateFormat dateFormat = new SimpleDateFormat ("yyyy.MM.dd");

    private final ResponseExtractor<Securities> securitiesExtractor;

    public QueryBuilder(RestTemplate restTemplate, ResponseExtractor<Securities> securitiesExtractor) {
        this(restTemplate, DEFAULT_URI, securitiesExtractor);
    }

    public QueryBuilder(
        RestTemplate restTemplate,
        String uri,
//        InReturnAdapterSpecification<RequestBody, String> requestBodyAdapter,
        ResponseExtractor<Securities> securitiesExtractor
    ) {
        super(restTemplate, uri);
//        this.requestBodyAdapter = requestBodyAdapter;
//        this.requestBody = new RequestBody (this);
//        headers = new HashMap<String, String> ();
        this.securitiesExtractor = securitiesExtractor;
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

    public QueryBuilder TA_WS () {

        extendPathWith(TA_WS);

        return this;
    }

    public QueryBuilder NP_WS () {

        extendPathWith(NP_WS);

        return this;
    }

//    /securities/Cusip(9#)/Date(MM/DD/YYYY)
    
    public QueryBuilder securities () {

        extendPathWith(SECURITIES);

        return this;
    }

    public QueryBuilder securities (SecurityType securityType) {

        extendPathWith(SECURITIES);

        Utils.assertNotNull ("securityType", securityType);

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

        extendPathWith(SECURITIES);
        extendPathWith(cusip);
        extendPathWith(date);

        return this;
    }

    public QueryBuilder withType (String type) {

        addParameter(TYPE, type);

        return this;
    }

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

        T result = (T) getCache().get(getKey ());

        if (result == null) {
            result = (T) getRestTemplate()
                .execute(getEscapedURI(), HttpMethod.GET, (RequestCallback) null, securitiesExtractor);
        }

        return result;
    }

    public Securities doGetAsSecurities () {

        addParameter(FORMAT, JSON);

        return doGet(Securities.class);
    }

//    public static void main (String[] unused) {
//
//        QueryBuilder queryBuilder = new QueryBuilder ();
//
//        String uri = queryBuilder.TA_WS().securities(SecurityType.FRN).getEscapedURI();
//
//        System.out.println("uri: " + uri);
//
//        Securities securities = queryBuilder.doGetAsSecurities();
//
//        System.out.println("securities: " + securities);
//    }
}