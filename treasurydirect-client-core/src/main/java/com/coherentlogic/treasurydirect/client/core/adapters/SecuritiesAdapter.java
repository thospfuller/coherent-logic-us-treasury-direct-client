package com.coherentlogic.treasurydirect.client.core.adapters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.coherentlogic.coherent.data.adapter.core.exceptions.ConversionFailedException;
import com.coherentlogic.coherent.data.adapter.core.exceptions.MethodNotSupportedException;
import com.coherentlogic.coherent.data.adapter.core.factories.TypedFactory;
import com.coherentlogic.treasurydirect.client.core.domain.Securities;
import com.coherentlogic.treasurydirect.client.core.domain.Security;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

/**
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class SecuritiesAdapter extends AbstractGSONBasedTypeAdapter<Securities> {

    private static final Logger log = LoggerFactory.getLogger(SecuritiesAdapter.class);

    public static final String BEAN_NAME = "securitiesAdapter";

    public SecuritiesAdapter(TypedFactory<Securities> typedFactory) {
        super(typedFactory);
    }

    public SecuritiesAdapter(GsonBuilder gsonBuilder, TypedFactory<Securities> typedFactory) {
        super(gsonBuilder, typedFactory);
    }

    @Override
    public Securities read(JsonReader reader) throws IOException {

        log.debug("read: method begins; reader: " + reader);

        Securities result = new Securities ();

        JsonElement securitiesElement = null;

        JsonToken token = reader.peek ();

        if (JsonToken.BEGIN_ARRAY.equals(token)) {
            securitiesElement = getGsonBuilder().create().fromJson(reader, JsonArray.class);
        } else if (JsonToken.BEGIN_OBJECT.equals(token)) {
            securitiesElement = getGsonBuilder().create().fromJson(reader, JsonObject.class);
        } else {
            throw new ConversionFailedException("Unable to convert the JSON into either an array or an object due to "
                + "an unsupported token type (token: " + token + ").");
        }

        if (securitiesElement.isJsonArray()) {

            JsonArray securityArray = securitiesElement.getAsJsonArray();

            List<Security> securityList = asSecurityList (securityArray);

            result.setSecurityList(securityList);

        } else {

            List<Security> securityList = new ArrayList<Security> ();

            Security security = asSecurity(securitiesElement.getAsJsonObject());

            securityList.add(security);

            result.setSecurityList(securityList);
        }

        log.debug("read: method ends; result: " + result);

        return result;
    }

    Security asSecurity (JsonObject securityObject) {

        log.debug("asSecurity: method begins; securityObject: " + securityObject);

        Security result = new Security ();

        if (!securityObject.has("cusip"))
            throw new ConversionFailedException("The JSON does not contain a member with name cusip");

        String cusip = securityObject.get("cusip").getAsString();

        log.debug("cusip: " + cusip);

        result.setCusip(cusip);

        if (!securityObject.has("issueDate"))
            throw new ConversionFailedException("The JSON does not contain a member with name issueDate");

        String issueDate = securityObject.get("issueDate").getAsString();

        log.debug("issueDate: " + issueDate);

        result.setIssueDate(issueDate);

        if (!securityObject.has("securityType"))
            throw new ConversionFailedException("The JSON does not contain a member with name securityType");

        String securityType = securityObject.get("securityType").getAsString();

        log.debug("securityType: " + securityType);

        result.setSecurityType(securityType);

        if (!securityObject.has("securityTerm"))
            throw new ConversionFailedException("The JSON does not contain a member with name securityTerm");

        String securityTerm = securityObject.get("securityTerm").getAsString();

        log.debug("securityTerm: " + securityTerm);

        result.setSecurityTerm(securityTerm);

        if (!securityObject.has("maturityDate"))
            throw new ConversionFailedException("The JSON does not contain a member with name maturityDate");

        String maturityDate = securityObject.get("maturityDate").getAsString();

        log.debug("maturityDate: " + maturityDate);

        result.setMaturityDate(maturityDate);

        if (!securityObject.has("interestRate"))
            throw new ConversionFailedException("The JSON does not contain a member with name interestRate");

        String interestRate = securityObject.get("interestRate").getAsString();

        log.debug("interestRate: " + interestRate);

        result.setInterestRate(interestRate);

        if (!securityObject.has("refCpiOnIssueDate"))
            throw new ConversionFailedException("The JSON does not contain a member with name refCpiOnIssueDate");

        String refCpiOnIssueDate = securityObject.get("refCpiOnIssueDate").getAsString();

        log.debug("refCpiOnIssueDate: " + refCpiOnIssueDate);

        result.setRefCpiOnIssueDate(refCpiOnIssueDate);

        if (!securityObject.has("refCpiOnDatedDate"))
            throw new ConversionFailedException("The JSON does not contain a member with name refCpiOnDatedDate");

        String refCpiOnDatedDate = securityObject.get("refCpiOnDatedDate").getAsString();

        log.debug("refCpiOnDatedDate: " + refCpiOnDatedDate);

        result.setRefCpiOnDatedDate(refCpiOnDatedDate);

        if (!securityObject.has("announcementDate"))
            throw new ConversionFailedException("The JSON does not contain a member with name announcementDate");

        String announcementDate = securityObject.get("announcementDate").getAsString();

        log.debug("announcementDate: " + announcementDate);

        result.setAnnouncementDate(announcementDate);

        if (!securityObject.has("auctionDate"))
            throw new ConversionFailedException("The JSON does not contain a member with name auctionDate");

        String auctionDate = securityObject.get("auctionDate").getAsString();

        log.debug("auctionDate: " + auctionDate);

        result.setAuctionDate(auctionDate);

        if (!securityObject.has("auctionDateYear"))
            throw new ConversionFailedException("The JSON does not contain a member with name auctionDateYear");

        String auctionDateYear = securityObject.get("auctionDateYear").getAsString();

        log.debug("auctionDateYear: " + auctionDateYear);

        result.setAuctionDateYear(auctionDateYear);

        if (!securityObject.has("datedDate"))
            throw new ConversionFailedException("The JSON does not contain a member with name datedDate");

        String datedDate = securityObject.get("datedDate").getAsString();

        log.debug("datedDate: " + datedDate);

        result.setDatedDate(datedDate);

        if (!securityObject.has("accruedInterestPer1000"))
            throw new ConversionFailedException("The JSON does not contain a member with name accruedInterestPer1000");

        String accruedInterestPer1000 = securityObject.get("accruedInterestPer1000").getAsString();

        log.debug("accruedInterestPer1000: " + accruedInterestPer1000);

        result.setAccruedInterestPer1000(accruedInterestPer1000);

        if (!securityObject.has("accruedInterestPer100"))
            throw new ConversionFailedException("The JSON does not contain a member with name accruedInterestPer100");

        String accruedInterestPer100 = securityObject.get("accruedInterestPer100").getAsString();

        log.debug("accruedInterestPer100: " + accruedInterestPer100);

        result.setAccruedInterestPer100(accruedInterestPer100);

        if (!securityObject.has("adjustedAccruedInterestPer1000"))
            throw new ConversionFailedException("The JSON does not contain a member with name adjustedAccruedInterestPer1000");

        String adjustedAccruedInterestPer1000 = securityObject.get("adjustedAccruedInterestPer1000").getAsString();

        log.debug("adjustedAccruedInterestPer1000: " + adjustedAccruedInterestPer1000);

        result.setAdjustedAccruedInterestPer1000(adjustedAccruedInterestPer1000);

        if (!securityObject.has("adjustedPrice"))
            throw new ConversionFailedException("The JSON does not contain a member with name adjustedPrice");

        String adjustedPrice = securityObject.get("adjustedPrice").getAsString();

        log.debug("adjustedPrice: " + adjustedPrice);

        result.setAdjustedPrice(adjustedPrice);

        if (!securityObject.has("allocationPercentage"))
            throw new ConversionFailedException("The JSON does not contain a member with name allocationPercentage");

        String allocationPercentage = securityObject.get("allocationPercentage").getAsString();

        log.debug("allocationPercentage: " + allocationPercentage);

        result.setAllocationPercentage(allocationPercentage);

        if (!securityObject.has("allocationPercentageDecimals"))
            throw new ConversionFailedException("The JSON does not contain a member with name allocationPercentageDecimals");

        String allocationPercentageDecimals = securityObject.get("allocationPercentageDecimals").getAsString();

        log.debug("allocationPercentageDecimals: " + allocationPercentageDecimals);

        result.setAllocationPercentageDecimals(allocationPercentageDecimals);

        if (!securityObject.has("announcedCusip"))
            throw new ConversionFailedException("The JSON does not contain a member with name announcedCusip");

        String announcedCusip = securityObject.get("announcedCusip").getAsString();

        log.debug("announcedCusip: " + announcedCusip);

        result.setAnnouncedCusip(announcedCusip);

        if (!securityObject.has("auctionFormat"))
            throw new ConversionFailedException("The JSON does not contain a member with name auctionFormat");

        String auctionFormat = securityObject.get("auctionFormat").getAsString();

        log.debug("auctionFormat: " + auctionFormat);

        result.setAuctionFormat(auctionFormat);

        if (!securityObject.has("averageMedianDiscountRate"))
            throw new ConversionFailedException("The JSON does not contain a member with name averageMedianDiscountRate");

        String averageMedianDiscountRate = securityObject.get("averageMedianDiscountRate").getAsString();

        log.debug("averageMedianDiscountRate: " + averageMedianDiscountRate);

        result.setAverageMedianDiscountRate(averageMedianDiscountRate);

        if (!securityObject.has("averageMedianInvestmentRate"))
            throw new ConversionFailedException("The JSON does not contain a member with name averageMedianInvestmentRate");

        String averageMedianInvestmentRate = securityObject.get("averageMedianInvestmentRate").getAsString();

        log.debug("averageMedianInvestmentRate: " + averageMedianInvestmentRate);

        result.setAverageMedianInvestmentRate(averageMedianInvestmentRate);

        if (!securityObject.has("averageMedianPrice"))
            throw new ConversionFailedException("The JSON does not contain a member with name averageMedianPrice");

        String averageMedianPrice = securityObject.get("averageMedianPrice").getAsString();

        log.debug("averageMedianPrice: " + averageMedianPrice);

        result.setAverageMedianPrice(averageMedianPrice);

        if (!securityObject.has("averageMedianDiscountMargin"))
            throw new ConversionFailedException("The JSON does not contain a member with name averageMedianDiscountMargin");

        String averageMedianDiscountMargin = securityObject.get("averageMedianDiscountMargin").getAsString();

        log.debug("averageMedianDiscountMargin: " + averageMedianDiscountMargin);

        result.setAverageMedianDiscountMargin(averageMedianDiscountMargin);

        if (!securityObject.has("averageMedianYield"))
            throw new ConversionFailedException("The JSON does not contain a member with name averageMedianYield");

        String averageMedianYield = securityObject.get("averageMedianYield").getAsString();

        log.debug("averageMedianYield: " + averageMedianYield);

        result.setAverageMedianYield(averageMedianYield);

        if (!securityObject.has("backDated"))
            throw new ConversionFailedException("The JSON does not contain a member with name backDated");

        String backDated = securityObject.get("backDated").getAsString();

        log.debug("backDated: " + backDated);

        result.setBackDated(backDated);

        if (!securityObject.has("backDatedDate"))
            throw new ConversionFailedException("The JSON does not contain a member with name backDatedDate");

        String backDatedDate = securityObject.get("backDatedDate").getAsString();

        log.debug("backDatedDate: " + backDatedDate);

        result.setBackDatedDate(backDatedDate);

        if (!securityObject.has("bidToCoverRatio"))
            throw new ConversionFailedException("The JSON does not contain a member with name bidToCoverRatio");

        String bidToCoverRatio = securityObject.get("bidToCoverRatio").getAsString();

        log.debug("bidToCoverRatio: " + bidToCoverRatio);

        result.setBidToCoverRatio(bidToCoverRatio);

        if (!securityObject.has("callDate"))
            throw new ConversionFailedException("The JSON does not contain a member with name callDate");

        String callDate = securityObject.get("callDate").getAsString();

        log.debug("callDate: " + callDate);

        result.setCallDate(callDate);

        if (!securityObject.has("callable"))
            throw new ConversionFailedException("The JSON does not contain a member with name callable");

        String callable = securityObject.get("callable").getAsString();

        log.debug("callable: " + callable);

        result.setCallable(callable);

        if (!securityObject.has("calledDate"))
            throw new ConversionFailedException("The JSON does not contain a member with name calledDate");

        String calledDate = securityObject.get("calledDate").getAsString();

        log.debug("calledDate: " + calledDate);

        result.setCalledDate(calledDate);

        if (!securityObject.has("cashManagementBillCMB"))
            throw new ConversionFailedException("The JSON does not contain a member with name cashManagementBillCMB");

        String cashManagementBillCMB = securityObject.get("cashManagementBillCMB").getAsString();

        log.debug("cashManagementBillCMB: " + cashManagementBillCMB);

        result.setCashManagementBillCMB(cashManagementBillCMB);

        if (!securityObject.has("closingTimeCompetitive"))
            throw new ConversionFailedException("The JSON does not contain a member with name closingTimeCompetitive");

        String closingTimeCompetitive = securityObject.get("closingTimeCompetitive").getAsString();

        log.debug("closingTimeCompetitive: " + closingTimeCompetitive);

        result.setClosingTimeCompetitive(closingTimeCompetitive);

        if (!securityObject.has("closingTimeNoncompetitive"))
            throw new ConversionFailedException("The JSON does not contain a member with name closingTimeNoncompetitive");

        String closingTimeNoncompetitive = securityObject.get("closingTimeNoncompetitive").getAsString();

        log.debug("closingTimeNoncompetitive: " + closingTimeNoncompetitive);

        result.setClosingTimeNoncompetitive(closingTimeNoncompetitive);

        if (!securityObject.has("competitiveAccepted"))
            throw new ConversionFailedException("The JSON does not contain a member with name competitiveAccepted");

        String competitiveAccepted = securityObject.get("competitiveAccepted").getAsString();

        log.debug("competitiveAccepted: " + competitiveAccepted);

        result.setCompetitiveAccepted(competitiveAccepted);

        if (!securityObject.has("competitiveBidDecimals"))
            throw new ConversionFailedException("The JSON does not contain a member with name competitiveBidDecimals");

        String competitiveBidDecimals = securityObject.get("competitiveBidDecimals").getAsString();

        log.debug("competitiveBidDecimals: " + competitiveBidDecimals);

        result.setCompetitiveBidDecimals(competitiveBidDecimals);

        if (!securityObject.has("competitiveTendered"))
            throw new ConversionFailedException("The JSON does not contain a member with name competitiveTendered");

        String competitiveTendered = securityObject.get("competitiveTendered").getAsString();

        log.debug("competitiveTendered: " + competitiveTendered);

        result.setCompetitiveTendered(competitiveTendered);

        if (!securityObject.has("competitiveTendersAccepted"))
            throw new ConversionFailedException("The JSON does not contain a member with name competitiveTendersAccepted");

        String competitiveTendersAccepted = securityObject.get("competitiveTendersAccepted").getAsString();

        log.debug("competitiveTendersAccepted: " + competitiveTendersAccepted);

        result.setCompetitiveTendersAccepted(competitiveTendersAccepted);

        if (!securityObject.has("corpusCusip"))
            throw new ConversionFailedException("The JSON does not contain a member with name corpusCusip");

        String corpusCusip = securityObject.get("corpusCusip").getAsString();

        log.debug("corpusCusip: " + corpusCusip);

        result.setCorpusCusip(corpusCusip);

        if (!securityObject.has("cpiBaseReferencePeriod"))
            throw new ConversionFailedException("The JSON does not contain a member with name cpiBaseReferencePeriod");

        String cpiBaseReferencePeriod = securityObject.get("cpiBaseReferencePeriod").getAsString();

        log.debug("cpiBaseReferencePeriod: " + cpiBaseReferencePeriod);

        result.setCpiBaseReferencePeriod(cpiBaseReferencePeriod);

        if (!securityObject.has("currentlyOutstanding"))
            throw new ConversionFailedException("The JSON does not contain a member with name currentlyOutstanding");

        String currentlyOutstanding = securityObject.get("currentlyOutstanding").getAsString();

        log.debug("currentlyOutstanding: " + currentlyOutstanding);

        result.setCurrentlyOutstanding(currentlyOutstanding);

        if (!securityObject.has("directBidderAccepted"))
            throw new ConversionFailedException("The JSON does not contain a member with name directBidderAccepted");

        String directBidderAccepted = securityObject.get("directBidderAccepted").getAsString();

        log.debug("directBidderAccepted: " + directBidderAccepted);

        result.setDirectBidderAccepted(directBidderAccepted);

        if (!securityObject.has("directBidderTendered"))
            throw new ConversionFailedException("The JSON does not contain a member with name directBidderTendered");

        String directBidderTendered = securityObject.get("directBidderTendered").getAsString();

        log.debug("directBidderTendered: " + directBidderTendered);

        result.setDirectBidderTendered(directBidderTendered);

        if (!securityObject.has("estimatedAmountOfPubliclyHeldMaturingSecuritiesByType"))
            throw new ConversionFailedException("The JSON does not contain a member with name estimatedAmountOfPubliclyHeldMaturingSecuritiesByType");

        String estimatedAmountOfPubliclyHeldMaturingSecuritiesByType = securityObject.get("estimatedAmountOfPubliclyHeldMaturingSecuritiesByType").getAsString();

        log.debug("estimatedAmountOfPubliclyHeldMaturingSecuritiesByType: " + estimatedAmountOfPubliclyHeldMaturingSecuritiesByType);

        result.setEstimatedAmountOfPubliclyHeldMaturingSecuritiesByType(estimatedAmountOfPubliclyHeldMaturingSecuritiesByType);

        if (!securityObject.has("fimaIncluded"))
            throw new ConversionFailedException("The JSON does not contain a member with name fimaIncluded");

        String fimaIncluded = securityObject.get("fimaIncluded").getAsString();

        log.debug("fimaIncluded: " + fimaIncluded);

        result.setFimaIncluded(fimaIncluded);

        if (!securityObject.has("fimaNoncompetitiveAccepted"))
            throw new ConversionFailedException("The JSON does not contain a member with name fimaNoncompetitiveAccepted");

        String fimaNoncompetitiveAccepted = securityObject.get("fimaNoncompetitiveAccepted").getAsString();

        log.debug("fimaNoncompetitiveAccepted: " + fimaNoncompetitiveAccepted);

        result.setFimaNoncompetitiveAccepted(fimaNoncompetitiveAccepted);

        if (!securityObject.has("fimaNoncompetitiveTendered"))
            throw new ConversionFailedException("The JSON does not contain a member with name fimaNoncompetitiveTendered");

        String fimaNoncompetitiveTendered = securityObject.get("fimaNoncompetitiveTendered").getAsString();

        log.debug("fimaNoncompetitiveTendered: " + fimaNoncompetitiveTendered);

        result.setFimaNoncompetitiveTendered(fimaNoncompetitiveTendered);

        if (!securityObject.has("firstInterestPeriod"))
            throw new ConversionFailedException("The JSON does not contain a member with name firstInterestPeriod");

        String firstInterestPeriod = securityObject.get("firstInterestPeriod").getAsString();

        log.debug("firstInterestPeriod: " + firstInterestPeriod);

        result.setFirstInterestPeriod(firstInterestPeriod);

        if (!securityObject.has("firstInterestPaymentDate"))
            throw new ConversionFailedException("The JSON does not contain a member with name firstInterestPaymentDate");

        String firstInterestPaymentDate = securityObject.get("firstInterestPaymentDate").getAsString();

        log.debug("firstInterestPaymentDate: " + firstInterestPaymentDate);

        result.setFirstInterestPaymentDate(firstInterestPaymentDate);

        if (!securityObject.has("floatingRate"))
            throw new ConversionFailedException("The JSON does not contain a member with name floatingRate");

        String floatingRate = securityObject.get("floatingRate").getAsString();

        log.debug("floatingRate: " + floatingRate);

        result.setFloatingRate(floatingRate);

        if (!securityObject.has("frnIndexDeterminationDate"))
            throw new ConversionFailedException("The JSON does not contain a member with name frnIndexDeterminationDate");

        String frnIndexDeterminationDate = securityObject.get("frnIndexDeterminationDate").getAsString();

        log.debug("frnIndexDeterminationDate: " + frnIndexDeterminationDate);

        result.setFrnIndexDeterminationDate(frnIndexDeterminationDate);

        if (!securityObject.has("frnIndexDeterminationRate"))
            throw new ConversionFailedException("The JSON does not contain a member with name frnIndexDeterminationRate");

        String frnIndexDeterminationRate = securityObject.get("frnIndexDeterminationRate").getAsString();

        log.debug("frnIndexDeterminationRate: " + frnIndexDeterminationRate);

        result.setFrnIndexDeterminationRate(frnIndexDeterminationRate);

        if (!securityObject.has("highDiscountRate"))
            throw new ConversionFailedException("The JSON does not contain a member with name highDiscountRate");

        String highDiscountRate = securityObject.get("highDiscountRate").getAsString();

        log.debug("highDiscountRate: " + highDiscountRate);

        result.setHighDiscountRate(highDiscountRate);

        if (!securityObject.has("highInvestmentRate"))
            throw new ConversionFailedException("The JSON does not contain a member with name highInvestmentRate");

        String highInvestmentRate = securityObject.get("highInvestmentRate").getAsString();

        log.debug("highInvestmentRate: " + highInvestmentRate);

        result.setHighInvestmentRate(highInvestmentRate);

        if (!securityObject.has("highPrice"))
            throw new ConversionFailedException("The JSON does not contain a member with name highPrice");

        String highPrice = securityObject.get("highPrice").getAsString();

        log.debug("highPrice: " + highPrice);

        result.setHighPrice(highPrice);

        if (!securityObject.has("highDiscountMargin"))
            throw new ConversionFailedException("The JSON does not contain a member with name highDiscountMargin");

        String highDiscountMargin = securityObject.get("highDiscountMargin").getAsString();

        log.debug("highDiscountMargin: " + highDiscountMargin);

        result.setHighDiscountMargin(highDiscountMargin);

        if (!securityObject.has("highYield"))
            throw new ConversionFailedException("The JSON does not contain a member with name highYield");

        String highYield = securityObject.get("highYield").getAsString();

        log.debug("highYield: " + highYield);

        result.setHighYield(highYield);

        if (!securityObject.has("indexRatioOnIssueDate"))
            throw new ConversionFailedException("The JSON does not contain a member with name indexRatioOnIssueDate");

        String indexRatioOnIssueDate = securityObject.get("indexRatioOnIssueDate").getAsString();

        log.debug("indexRatioOnIssueDate: " + indexRatioOnIssueDate);

        result.setIndexRatioOnIssueDate(indexRatioOnIssueDate);

        if (!securityObject.has("indirectBidderAccepted"))
            throw new ConversionFailedException("The JSON does not contain a member with name indirectBidderAccepted");

        String indirectBidderAccepted = securityObject.get("indirectBidderAccepted").getAsString();

        log.debug("indirectBidderAccepted: " + indirectBidderAccepted);

        result.setIndirectBidderAccepted(indirectBidderAccepted);

        if (!securityObject.has("indirectBidderTendered"))
            throw new ConversionFailedException("The JSON does not contain a member with name indirectBidderTendered");

        String indirectBidderTendered = securityObject.get("indirectBidderTendered").getAsString();

        log.debug("indirectBidderTendered: " + indirectBidderTendered);

        result.setIndirectBidderTendered(indirectBidderTendered);

        if (!securityObject.has("interestPaymentFrequency"))
            throw new ConversionFailedException("The JSON does not contain a member with name interestPaymentFrequency");

        String interestPaymentFrequency = securityObject.get("interestPaymentFrequency").getAsString();

        log.debug("interestPaymentFrequency: " + interestPaymentFrequency);

        result.setInterestPaymentFrequency(interestPaymentFrequency);

        if (!securityObject.has("lowDiscountRate"))
            throw new ConversionFailedException("The JSON does not contain a member with name lowDiscountRate");

        String lowDiscountRate = securityObject.get("lowDiscountRate").getAsString();

        log.debug("lowDiscountRate: " + lowDiscountRate);

        result.setLowDiscountRate(lowDiscountRate);

        if (!securityObject.has("lowInvestmentRate"))
            throw new ConversionFailedException("The JSON does not contain a member with name lowInvestmentRate");

        String lowInvestmentRate = securityObject.get("lowInvestmentRate").getAsString();

        log.debug("lowInvestmentRate: " + lowInvestmentRate);

        result.setLowInvestmentRate(lowInvestmentRate);

        if (!securityObject.has("lowPrice"))
            throw new ConversionFailedException("The JSON does not contain a member with name lowPrice");

        String lowPrice = securityObject.get("lowPrice").getAsString();

        log.debug("lowPrice: " + lowPrice);

        result.setLowPrice(lowPrice);

        if (!securityObject.has("lowDiscountMargin"))
            throw new ConversionFailedException("The JSON does not contain a member with name lowDiscountMargin");

        String lowDiscountMargin = securityObject.get("lowDiscountMargin").getAsString();

        log.debug("lowDiscountMargin: " + lowDiscountMargin);

        result.setLowDiscountMargin(lowDiscountMargin);

        if (!securityObject.has("lowYield"))
            throw new ConversionFailedException("The JSON does not contain a member with name lowYield");

        String lowYield = securityObject.get("lowYield").getAsString();

        log.debug("lowYield: " + lowYield);

        result.setLowYield(lowYield);

        if (!securityObject.has("maturingDate"))
            throw new ConversionFailedException("The JSON does not contain a member with name maturingDate");

        String maturingDate = securityObject.get("maturingDate").getAsString();

        log.debug("maturingDate: " + maturingDate);

        result.setMaturingDate(maturingDate);

        if (!securityObject.has("maximumCompetitiveAward"))
            throw new ConversionFailedException("The JSON does not contain a member with name maximumCompetitiveAward");

        String maximumCompetitiveAward = securityObject.get("maximumCompetitiveAward").getAsString();

        log.debug("maximumCompetitiveAward: " + maximumCompetitiveAward);

        result.setMaximumCompetitiveAward(maximumCompetitiveAward);

        if (!securityObject.has("maximumNoncompetitiveAward"))
            throw new ConversionFailedException("The JSON does not contain a member with name maximumNoncompetitiveAward");

        String maximumNoncompetitiveAward = securityObject.get("maximumNoncompetitiveAward").getAsString();

        log.debug("maximumNoncompetitiveAward: " + maximumNoncompetitiveAward);

        result.setMaximumNoncompetitiveAward(maximumNoncompetitiveAward);

        if (!securityObject.has("maximumSingleBid"))
            throw new ConversionFailedException("The JSON does not contain a member with name maximumSingleBid");

        String maximumSingleBid = securityObject.get("maximumSingleBid").getAsString();

        log.debug("maximumSingleBid: " + maximumSingleBid);

        result.setMaximumSingleBid(maximumSingleBid);

        if (!securityObject.has("minimumBidAmount"))
            throw new ConversionFailedException("The JSON does not contain a member with name minimumBidAmount");

        String minimumBidAmount = securityObject.get("minimumBidAmount").getAsString();

        log.debug("minimumBidAmount: " + minimumBidAmount);

        result.setMinimumBidAmount(minimumBidAmount);

        if (!securityObject.has("minimumStripAmount"))
            throw new ConversionFailedException("The JSON does not contain a member with name minimumStripAmount");

        String minimumStripAmount = securityObject.get("minimumStripAmount").getAsString();

        log.debug("minimumStripAmount: " + minimumStripAmount);

        result.setMinimumStripAmount(minimumStripAmount);

        if (!securityObject.has("minimumToIssue"))
            throw new ConversionFailedException("The JSON does not contain a member with name minimumToIssue");

        String minimumToIssue = securityObject.get("minimumToIssue").getAsString();

        log.debug("minimumToIssue: " + minimumToIssue);

        result.setMinimumToIssue(minimumToIssue);

        if (!securityObject.has("multiplesToBid"))
            throw new ConversionFailedException("The JSON does not contain a member with name multiplesToBid");

        String multiplesToBid = securityObject.get("multiplesToBid").getAsString();

        log.debug("multiplesToBid: " + multiplesToBid);

        result.setMultiplesToBid(multiplesToBid);

        if (!securityObject.has("multiplesToIssue"))
            throw new ConversionFailedException("The JSON does not contain a member with name multiplesToIssue");

        String multiplesToIssue = securityObject.get("multiplesToIssue").getAsString();

        log.debug("multiplesToIssue: " + multiplesToIssue);

        result.setMultiplesToIssue(multiplesToIssue);

        if (!securityObject.has("nlpExclusionAmount"))
            throw new ConversionFailedException("The JSON does not contain a member with name nlpExclusionAmount");

        String nlpExclusionAmount = securityObject.get("nlpExclusionAmount").getAsString();

        log.debug("nlpExclusionAmount: " + nlpExclusionAmount);

        result.setNlpExclusionAmount(nlpExclusionAmount);

        if (!securityObject.has("nlpReportingThreshold"))
            throw new ConversionFailedException("The JSON does not contain a member with name nlpReportingThreshold");

        String nlpReportingThreshold = securityObject.get("nlpReportingThreshold").getAsString();

        log.debug("nlpReportingThreshold: " + nlpReportingThreshold);

        result.setNlpReportingThreshold(nlpReportingThreshold);

        if (!securityObject.has("noncompetitiveAccepted"))
            throw new ConversionFailedException("The JSON does not contain a member with name noncompetitiveAccepted");

        String noncompetitiveAccepted = securityObject.get("noncompetitiveAccepted").getAsString();

        log.debug("noncompetitiveAccepted: " + noncompetitiveAccepted);

        result.setNoncompetitiveAccepted(noncompetitiveAccepted);

        if (!securityObject.has("noncompetitiveTendersAccepted"))
            throw new ConversionFailedException("The JSON does not contain a member with name noncompetitiveTendersAccepted");

        String noncompetitiveTendersAccepted = securityObject.get("noncompetitiveTendersAccepted").getAsString();

        log.debug("noncompetitiveTendersAccepted: " + noncompetitiveTendersAccepted);

        result.setNoncompetitiveTendersAccepted(noncompetitiveTendersAccepted);

        if (!securityObject.has("offeringAmount"))
            throw new ConversionFailedException("The JSON does not contain a member with name offeringAmount");

        String offeringAmount = securityObject.get("offeringAmount").getAsString();

        log.debug("offeringAmount: " + offeringAmount);

        result.setOfferingAmount(offeringAmount);

        if (!securityObject.has("originalCusip"))
            throw new ConversionFailedException("The JSON does not contain a member with name originalCusip");

        String originalCusip = securityObject.get("originalCusip").getAsString();

        log.debug("originalCusip: " + originalCusip);

        result.setOriginalCusip(originalCusip);

        if (!securityObject.has("originalDatedDate"))
            throw new ConversionFailedException("The JSON does not contain a member with name originalDatedDate");

        String originalDatedDate = securityObject.get("originalDatedDate").getAsString();

        log.debug("originalDatedDate: " + originalDatedDate);

        result.setOriginalDatedDate(originalDatedDate);

        if (!securityObject.has("originalIssueDate"))
            throw new ConversionFailedException("The JSON does not contain a member with name originalIssueDate");

        String originalIssueDate = securityObject.get("originalIssueDate").getAsString();

        log.debug("originalIssueDate: " + originalIssueDate);

        result.setOriginalIssueDate(originalIssueDate);

        if (!securityObject.has("originalSecurityTerm"))
            throw new ConversionFailedException("The JSON does not contain a member with name originalSecurityTerm");

        String originalSecurityTerm = securityObject.get("originalSecurityTerm").getAsString();

        log.debug("originalSecurityTerm: " + originalSecurityTerm);

        result.setOriginalSecurityTerm(originalSecurityTerm);

        if (!securityObject.has("pdfFilenameAnnouncement"))
            throw new ConversionFailedException("The JSON does not contain a member with name pdfFilenameAnnouncement");

        String pdfFilenameAnnouncement = securityObject.get("pdfFilenameAnnouncement").getAsString();

        log.debug("pdfFilenameAnnouncement: " + pdfFilenameAnnouncement);

        result.setPdfFilenameAnnouncement(pdfFilenameAnnouncement);

        if (!securityObject.has("pdfFilenameCompetitiveResults"))
            throw new ConversionFailedException("The JSON does not contain a member with name pdfFilenameCompetitiveResults");

        String pdfFilenameCompetitiveResults = securityObject.get("pdfFilenameCompetitiveResults").getAsString();

        log.debug("pdfFilenameCompetitiveResults: " + pdfFilenameCompetitiveResults);

        result.setPdfFilenameCompetitiveResults(pdfFilenameCompetitiveResults);

        if (!securityObject.has("pdfFilenameNoncompetitiveResults"))
            throw new ConversionFailedException("The JSON does not contain a member with name pdfFilenameNoncompetitiveResults");

        String pdfFilenameNoncompetitiveResults = securityObject.get("pdfFilenameNoncompetitiveResults").getAsString();

        log.debug("pdfFilenameNoncompetitiveResults: " + pdfFilenameNoncompetitiveResults);

        result.setPdfFilenameNoncompetitiveResults(pdfFilenameNoncompetitiveResults);

        if (!securityObject.has("pdfFilenameSpecialAnnouncement"))
            throw new ConversionFailedException("The JSON does not contain a member with name pdfFilenameSpecialAnnouncement");

        String pdfFilenameSpecialAnnouncement = securityObject.get("pdfFilenameSpecialAnnouncement").getAsString();

        log.debug("pdfFilenameSpecialAnnouncement: " + pdfFilenameSpecialAnnouncement);

        result.setPdfFilenameSpecialAnnouncement(pdfFilenameSpecialAnnouncement);

        if (!securityObject.has("pricePer100"))
            throw new ConversionFailedException("The JSON does not contain a member with name pricePer100");

        String pricePer100 = securityObject.get("pricePer100").getAsString();

        log.debug("pricePer100: " + pricePer100);

        result.setPricePer100(pricePer100);

        if (!securityObject.has("primaryDealerAccepted"))
            throw new ConversionFailedException("The JSON does not contain a member with name primaryDealerAccepted");

        String primaryDealerAccepted = securityObject.get("primaryDealerAccepted").getAsString();

        log.debug("primaryDealerAccepted: " + primaryDealerAccepted);

        result.setPrimaryDealerAccepted(primaryDealerAccepted);

        if (!securityObject.has("primaryDealerTendered"))
            throw new ConversionFailedException("The JSON does not contain a member with name primaryDealerTendered");

        String primaryDealerTendered = securityObject.get("primaryDealerTendered").getAsString();

        log.debug("primaryDealerTendered: " + primaryDealerTendered);

        result.setPrimaryDealerTendered(primaryDealerTendered);

        if (!securityObject.has("reopening"))
            throw new ConversionFailedException("The JSON does not contain a member with name reopening");

        String reopening = securityObject.get("reopening").getAsString();

        log.debug("reopening: " + reopening);

        result.setReopening(reopening);

        if (!securityObject.has("securityTermDayMonth"))
            throw new ConversionFailedException("The JSON does not contain a member with name securityTermDayMonth");

        String securityTermDayMonth = securityObject.get("securityTermDayMonth").getAsString();

        log.debug("securityTermDayMonth: " + securityTermDayMonth);

        result.setSecurityTermDayMonth(securityTermDayMonth);

        if (!securityObject.has("securityTermWeekYear"))
            throw new ConversionFailedException("The JSON does not contain a member with name securityTermWeekYear");

        String securityTermWeekYear = securityObject.get("securityTermWeekYear").getAsString();

        log.debug("securityTermWeekYear: " + securityTermWeekYear);

        result.setSecurityTermWeekYear(securityTermWeekYear);

        if (!securityObject.has("series"))
            throw new ConversionFailedException("The JSON does not contain a member with name series");

        String series = securityObject.get("series").getAsString();

        log.debug("series: " + series);

        result.setSeries(series);

        if (!securityObject.has("somaAccepted"))
            throw new ConversionFailedException("The JSON does not contain a member with name somaAccepted");

        String somaAccepted = securityObject.get("somaAccepted").getAsString();

        log.debug("somaAccepted: " + somaAccepted);

        result.setSomaAccepted(somaAccepted);

        if (!securityObject.has("somaHoldings"))
            throw new ConversionFailedException("The JSON does not contain a member with name somaHoldings");

        String somaHoldings = securityObject.get("somaHoldings").getAsString();

        log.debug("somaHoldings: " + somaHoldings);

        result.setSomaHoldings(somaHoldings);

        if (!securityObject.has("somaIncluded"))
            throw new ConversionFailedException("The JSON does not contain a member with name somaIncluded");

        String somaIncluded = securityObject.get("somaIncluded").getAsString();

        log.debug("somaIncluded: " + somaIncluded);

        result.setSomaIncluded(somaIncluded);

        if (!securityObject.has("somaTendered"))
            throw new ConversionFailedException("The JSON does not contain a member with name somaTendered");

        String somaTendered = securityObject.get("somaTendered").getAsString();

        log.debug("somaTendered: " + somaTendered);

        result.setSomaTendered(somaTendered);

        if (!securityObject.has("spread"))
            throw new ConversionFailedException("The JSON does not contain a member with name spread");

        String spread = securityObject.get("spread").getAsString();

        log.debug("spread: " + spread);

        result.setSpread(spread);

        if (!securityObject.has("standardInterestPaymentPer1000"))
            throw new ConversionFailedException("The JSON does not contain a member with name standardInterestPaymentPer1000");

        String standardInterestPaymentPer1000 = securityObject.get("standardInterestPaymentPer1000").getAsString();

        log.debug("standardInterestPaymentPer1000: " + standardInterestPaymentPer1000);

        result.setStandardInterestPaymentPer1000(standardInterestPaymentPer1000);

        if (!securityObject.has("strippable"))
            throw new ConversionFailedException("The JSON does not contain a member with name strippable");

        String strippable = securityObject.get("strippable").getAsString();

        log.debug("strippable: " + strippable);

        result.setStrippable(strippable);

        if (!securityObject.has("term"))
            throw new ConversionFailedException("The JSON does not contain a member with name term");

        String term = securityObject.get("term").getAsString();

        log.debug("term: " + term);

        result.setTerm(term);

        if (!securityObject.has("tiinConversionFactorPer1000"))
            throw new ConversionFailedException("The JSON does not contain a member with name tiinConversionFactorPer1000");

        String tiinConversionFactorPer1000 = securityObject.get("tiinConversionFactorPer1000").getAsString();

        log.debug("tiinConversionFactorPer1000: " + tiinConversionFactorPer1000);

        result.setTiinConversionFactorPer1000(tiinConversionFactorPer1000);

        if (!securityObject.has("tips"))
            throw new ConversionFailedException("The JSON does not contain a member with name tips");

        String tips = securityObject.get("tips").getAsString();

        log.debug("tips: " + tips);

        result.setTips(tips);

        if (!securityObject.has("totalAccepted"))
            throw new ConversionFailedException("The JSON does not contain a member with name totalAccepted");

        String totalAccepted = securityObject.get("totalAccepted").getAsString();

        log.debug("totalAccepted: " + totalAccepted);

        result.setTotalAccepted(totalAccepted);

        if (!securityObject.has("totalTendered"))
            throw new ConversionFailedException("The JSON does not contain a member with name totalTendered");

        String totalTendered = securityObject.get("totalTendered").getAsString();

        log.debug("totalTendered: " + totalTendered);

        result.setTotalTendered(totalTendered);

        if (!securityObject.has("treasuryDirectAccepted"))
            throw new ConversionFailedException("The JSON does not contain a member with name treasuryDirectAccepted");

        String treasuryDirectAccepted = securityObject.get("treasuryDirectAccepted").getAsString();

        log.debug("treasuryDirectAccepted: " + treasuryDirectAccepted);

        result.setTreasuryDirectAccepted(treasuryDirectAccepted);

        if (!securityObject.has("treasuryDirectTendersAccepted"))
            throw new ConversionFailedException("The JSON does not contain a member with name treasuryDirectTendersAccepted");

        String treasuryDirectTendersAccepted = securityObject.get("treasuryDirectTendersAccepted").getAsString();

        log.debug("treasuryDirectTendersAccepted: " + treasuryDirectTendersAccepted);

        result.setTreasuryDirectTendersAccepted(treasuryDirectTendersAccepted);

        if (!securityObject.has("type"))
            throw new ConversionFailedException("The JSON does not contain a member with name type");

        String type = securityObject.get("type").getAsString();

        log.debug("type: " + type);

        result.setType(type);

        if (!securityObject.has("unadjustedAccruedInterestPer1000"))
            throw new ConversionFailedException("The JSON does not contain a member with name unadjustedAccruedInterestPer1000");

        String unadjustedAccruedInterestPer1000 = securityObject.get("unadjustedAccruedInterestPer1000").getAsString();

        log.debug("unadjustedAccruedInterestPer1000: " + unadjustedAccruedInterestPer1000);

        result.setUnadjustedAccruedInterestPer1000(unadjustedAccruedInterestPer1000);

        if (!securityObject.has("unadjustedPrice"))
            throw new ConversionFailedException("The JSON does not contain a member with name unadjustedPrice");

        String unadjustedPrice = securityObject.get("unadjustedPrice").getAsString();

        log.debug("unadjustedPrice: " + unadjustedPrice);

        result.setUnadjustedPrice(unadjustedPrice);

        if (!securityObject.has("updatedTimestamp"))
            throw new ConversionFailedException("The JSON does not contain a member with name updatedTimestamp");

        String updatedTimestamp = securityObject.get("updatedTimestamp").getAsString();

        log.debug("updatedTimestamp: " + updatedTimestamp);

        result.setUpdatedTimestamp(updatedTimestamp);

        if (!securityObject.has("xmlFilenameAnnouncement"))
            throw new ConversionFailedException("The JSON does not contain a member with name xmlFilenameAnnouncement");

        String xmlFilenameAnnouncement = securityObject.get("xmlFilenameAnnouncement").getAsString();

        log.debug("xmlFilenameAnnouncement: " + xmlFilenameAnnouncement);

        result.setXmlFilenameAnnouncement(xmlFilenameAnnouncement);

        if (!securityObject.has("xmlFilenameCompetitiveResults"))
            throw new ConversionFailedException("The JSON does not contain a member with name xmlFilenameCompetitiveResults");

        String xmlFilenameCompetitiveResults = securityObject.get("xmlFilenameCompetitiveResults").getAsString();

        log.debug("xmlFilenameCompetitiveResults: " + xmlFilenameCompetitiveResults);

        result.setXmlFilenameCompetitiveResults(xmlFilenameCompetitiveResults);

        if (!securityObject.has("xmlFilenameSpecialAnnouncement"))
            throw new ConversionFailedException("The JSON does not contain a member with name xmlFilenameSpecialAnnouncement");

        String xmlFilenameSpecialAnnouncement = securityObject.get("xmlFilenameSpecialAnnouncement").getAsString();

        log.debug("xmlFilenameSpecialAnnouncement: " + xmlFilenameSpecialAnnouncement);

        result.setXmlFilenameSpecialAnnouncement(xmlFilenameSpecialAnnouncement);

        log.debug("asSecurity: method ends; result: " + result);

        return result;
    }

    List<Security> asSecurityList (JsonArray securityArray) {

        List<Security> result = new ArrayList<Security> ();

        securityArray.forEach(
            element -> {

                Security security = asSecurity ((JsonObject) element);

                result.add(security);
            }
        );

        return result;
    }
    

    @Override
    public void write(JsonWriter writer, Securities securities) throws IOException {
        throw new MethodNotSupportedException ("The write method is not supported.");
    }
}
