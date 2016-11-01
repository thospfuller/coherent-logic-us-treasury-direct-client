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

        Security result = new Security ();

        String cusip = securityObject.get(Security.CUSIP).getAsString();

        log.debug("cusip: " + cusip);

        result.setCusip(cusip);

        String issueDate = securityObject.get("issueDate").getAsString();

        log.debug("issueDate: " + issueDate);

        result.setIssueDate(issueDate);

        String securityType = securityObject.get("securityType").getAsString();

        log.debug("securityType: " + securityType);

        result.setSecurityType(securityType);

        String securityTerm = securityObject.get("securityTerm").getAsString();

        log.debug("securityTerm: " + securityTerm);

        result.setSecurityTerm(securityTerm);

        String maturityDate = securityObject.get("maturityDate").getAsString();

        log.debug("maturityDate: " + maturityDate);

        result.setMaturityDate(maturityDate);

        String interestRate = securityObject.get("interestRate").getAsString();

        log.debug("interestRate: " + interestRate);

        result.setInterestRate(interestRate);

        String refCpiOnIssueDate = securityObject.get("refCpiOnIssueDate").getAsString();

        log.debug("refCpiOnIssueDate: " + refCpiOnIssueDate);

        result.setRefCpiOnIssueDate(refCpiOnIssueDate);

        String refCpiOnDatedDate = securityObject.get("refCpiOnDatedDate").getAsString();

        log.debug("refCpiOnDatedDate: " + refCpiOnDatedDate);

        result.setRefCpiOnDatedDate(refCpiOnDatedDate);

        String announcementDate = securityObject.get("announcementDate").getAsString();

        log.debug("announcementDate: " + announcementDate);

        result.setAnnouncementDate(announcementDate);

        String auctionDate = securityObject.get("auctionDate").getAsString();

        log.debug("auctionDate: " + auctionDate);

        result.setAuctionDate(auctionDate);

        String auctionDateYear = securityObject.get("auctionDateYear").getAsString();

        log.debug("auctionDateYear: " + auctionDateYear);

        result.setAuctionDateYear(auctionDateYear);

        String datedDate = securityObject.get("datedDate").getAsString();

        log.debug("datedDate: " + datedDate);

        result.setDatedDate(datedDate);

        String accruedInterestPer1000 = securityObject.get("accruedInterestPer1000").getAsString();

        log.debug("accruedInterestPer1000: " + accruedInterestPer1000);

        result.setAccruedInterestPer1000(accruedInterestPer1000);

        String accruedInterestPer100 = securityObject.get("accruedInterestPer100").getAsString();

        log.debug("accruedInterestPer100: " + accruedInterestPer100);

        result.setAccruedInterestPer100(accruedInterestPer100);

        String adjustedAccruedInterestPer1000 = securityObject.get("adjustedAccruedInterestPer1000").getAsString();

        log.debug("adjustedAccruedInterestPer1000: " + adjustedAccruedInterestPer1000);

        result.setAdjustedAccruedInterestPer1000(adjustedAccruedInterestPer1000);

        String adjustedPrice = securityObject.get("adjustedPrice").getAsString();

        log.debug("adjustedPrice: " + adjustedPrice);

        result.setAdjustedPrice(adjustedPrice);

        String allocationPercentage = securityObject.get("allocationPercentage").getAsString();

        log.debug("allocationPercentage: " + allocationPercentage);

        result.setAllocationPercentage(allocationPercentage);

        String allocationPercentageDecimals = securityObject.get("allocationPercentageDecimals").getAsString();

        log.debug("allocationPercentageDecimals: " + allocationPercentageDecimals);

        result.setAllocationPercentageDecimals(allocationPercentageDecimals);

        String announcedCusip = securityObject.get("announcedCusip").getAsString();

        log.debug("announcedCusip: " + announcedCusip);

        result.setAnnouncedCusip(announcedCusip);

        String auctionFormat = securityObject.get("auctionFormat").getAsString();

        log.debug("auctionFormat: " + auctionFormat);

        result.setAuctionFormat(auctionFormat);

        String averageMedianDiscountRate = securityObject.get("averageMedianDiscountRate").getAsString();

        log.debug("averageMedianDiscountRate: " + averageMedianDiscountRate);

        result.setAverageMedianDiscountRate(averageMedianDiscountRate);

        String averageMedianInvestmentRate = securityObject.get("averageMedianInvestmentRate").getAsString();

        log.debug("averageMedianInvestmentRate: " + averageMedianInvestmentRate);

        result.setAverageMedianInvestmentRate(averageMedianInvestmentRate);

        String averageMedianPrice = securityObject.get("averageMedianPrice").getAsString();

        log.debug("averageMedianPrice: " + averageMedianPrice);

        result.setAverageMedianPrice(averageMedianPrice);

        String averageMedianDiscountMargin = securityObject.get("averageMedianDiscountMargin").getAsString();

        log.debug("averageMedianDiscountMargin: " + averageMedianDiscountMargin);

        result.setAverageMedianDiscountMargin(averageMedianDiscountMargin);

        String averageMedianYield = securityObject.get("averageMedianYield").getAsString();

        log.debug("averageMedianYield: " + averageMedianYield);

        result.setAverageMedianYield(averageMedianYield);

        String backDated = securityObject.get("backDated").getAsString();

        log.debug("backDated: " + backDated);

        result.setBackDated(backDated);

        String backDatedDate = securityObject.get("backDatedDate").getAsString();

        log.debug("backDatedDate: " + backDatedDate);

        result.setBackDatedDate(backDatedDate);

        String bidToCoverRatio = securityObject.get("bidToCoverRatio").getAsString();

        log.debug("bidToCoverRatio: " + bidToCoverRatio);

        result.setBidToCoverRatio(bidToCoverRatio);

        String callDate = securityObject.get("callDate").getAsString();

        log.debug("callDate: " + callDate);

        result.setCallDate(callDate);

        String callable = securityObject.get("callable").getAsString();

        log.debug("callable: " + callable);

        result.setCallable(callable);

        String calledDate = securityObject.get("calledDate").getAsString();

        log.debug("calledDate: " + calledDate);

        result.setCalledDate(calledDate);

        String cashManagementBillCMB = securityObject.get("cashManagementBillCMB").getAsString();

        log.debug("cashManagementBillCMB: " + cashManagementBillCMB);

        result.setCashManagementBillCMB(cashManagementBillCMB);

        String closingTimeCompetitive = securityObject.get("closingTimeCompetitive").getAsString();

        log.debug("closingTimeCompetitive: " + closingTimeCompetitive);

        result.setClosingTimeCompetitive(closingTimeCompetitive);

        String closingTimeNoncompetitive = securityObject.get("closingTimeNoncompetitive").getAsString();

        log.debug("closingTimeNoncompetitive: " + closingTimeNoncompetitive);

        result.setClosingTimeNoncompetitive(closingTimeNoncompetitive);

        String competitiveAccepted = securityObject.get("competitiveAccepted").getAsString();

        log.debug("competitiveAccepted: " + competitiveAccepted);

        result.setCompetitiveAccepted(competitiveAccepted);

        String competitiveBidDecimals = securityObject.get("competitiveBidDecimals").getAsString();

        log.debug("competitiveBidDecimals: " + competitiveBidDecimals);

        result.setCompetitiveBidDecimals(competitiveBidDecimals);

        String competitiveTendered = securityObject.get("competitiveTendered").getAsString();

        log.debug("competitiveTendered: " + competitiveTendered);

        result.setCompetitiveTendered(competitiveTendered);

        String competitiveTendersAccepted = securityObject.get("competitiveTendersAccepted").getAsString();

        log.debug("competitiveTendersAccepted: " + competitiveTendersAccepted);

        result.setCompetitiveTendersAccepted(competitiveTendersAccepted);

        String corpusCusip = securityObject.get("corpusCusip").getAsString();

        log.debug("corpusCusip: " + corpusCusip);

        result.setCorpusCusip(corpusCusip);

        String cpiBaseReferencePeriod = securityObject.get("cpiBaseReferencePeriod").getAsString();

        log.debug("cpiBaseReferencePeriod: " + cpiBaseReferencePeriod);

        result.setCpiBaseReferencePeriod(cpiBaseReferencePeriod);

        String currentlyOutstanding = securityObject.get("currentlyOutstanding").getAsString();

        log.debug("currentlyOutstanding: " + currentlyOutstanding);

        result.setCurrentlyOutstanding(currentlyOutstanding);

        String directBidderAccepted = securityObject.get("directBidderAccepted").getAsString();

        log.debug("directBidderAccepted: " + directBidderAccepted);

        result.setDirectBidderAccepted(directBidderAccepted);

        String directBidderTendered = securityObject.get("directBidderTendered").getAsString();

        log.debug("directBidderTendered: " + directBidderTendered);

        result.setDirectBidderTendered(directBidderTendered);

        String estimatedAmountOfPubliclyHeldMaturingSecuritiesByType =
            securityObject.get("estimatedAmountOfPubliclyHeldMaturingSecuritiesByType").getAsString();

        log.debug("estimatedAmountOfPubliclyHeldMaturingSecuritiesByType: " +
            estimatedAmountOfPubliclyHeldMaturingSecuritiesByType);

        result.setEstimatedAmountOfPubliclyHeldMaturingSecuritiesByType(
            estimatedAmountOfPubliclyHeldMaturingSecuritiesByType);

        String fimaIncluded = securityObject.get("fimaIncluded").getAsString();

        log.debug("fimaIncluded: " + fimaIncluded);

        result.setFimaIncluded(fimaIncluded);

        String fimaNoncompetitiveAccepted = securityObject.get("fimaNoncompetitiveAccepted").getAsString();

        log.debug("fimaNoncompetitiveAccepted: " + fimaNoncompetitiveAccepted);

        result.setFimaNoncompetitiveAccepted(fimaNoncompetitiveAccepted);

        String fimaNoncompetitiveTendered = securityObject.get("fimaNoncompetitiveTendered").getAsString();

        log.debug("fimaNoncompetitiveTendered: " + fimaNoncompetitiveTendered);

        result.setFimaNoncompetitiveTendered(fimaNoncompetitiveTendered);

        String firstInterestPeriod = securityObject.get("firstInterestPeriod").getAsString();

        log.debug("firstInterestPeriod: " + firstInterestPeriod);

        result.setFirstInterestPeriod(firstInterestPeriod);

        String firstInterestPaymentDate = securityObject.get("firstInterestPaymentDate").getAsString();

        log.debug("firstInterestPaymentDate: " + firstInterestPaymentDate);

        result.setFirstInterestPaymentDate(firstInterestPaymentDate);

        String floatingRate = securityObject.get("floatingRate").getAsString();

        log.debug("floatingRate: " + floatingRate);

        result.setFloatingRate(floatingRate);

        String frnIndexDeterminationDate = securityObject.get("frnIndexDeterminationDate").getAsString();

        log.debug("frnIndexDeterminationDate: " + frnIndexDeterminationDate);

        result.setFrnIndexDeterminationDate(frnIndexDeterminationDate);

        String frnIndexDeterminationRate = securityObject.get("frnIndexDeterminationRate").getAsString();

        log.debug("frnIndexDeterminationRate: " + frnIndexDeterminationRate);

        result.setFrnIndexDeterminationRate(frnIndexDeterminationRate);

        String highDiscountRate = securityObject.get("highDiscountRate").getAsString();

        log.debug("highDiscountRate: " + highDiscountRate);

        result.setHighDiscountRate(highDiscountRate);

        String highInvestmentRate = securityObject.get("highInvestmentRate").getAsString();

        log.debug("highInvestmentRate: " + highInvestmentRate);

        result.setHighInvestmentRate(highInvestmentRate);

        String highPrice = securityObject.get("highPrice").getAsString();

        log.debug("highPrice: " + highPrice);

        result.setHighPrice(highPrice);

        String highDiscountMargin = securityObject.get("highDiscountMargin").getAsString();

        log.debug("highDiscountMargin: " + highDiscountMargin);

        result.setHighDiscountMargin(highDiscountMargin);

        String highYield = securityObject.get("highYield").getAsString();

        log.debug("highYield: " + highYield);

        result.setHighYield(highYield);

        String indexRatioOnIssueDate = securityObject.get("indexRatioOnIssueDate").getAsString();

        log.debug("indexRatioOnIssueDate: " + indexRatioOnIssueDate);

        result.setIndexRatioOnIssueDate(indexRatioOnIssueDate);

        String indirectBidderAccepted = securityObject.get("indirectBidderAccepted").getAsString();

        log.debug("indirectBidderAccepted: " + indirectBidderAccepted);

        result.setIndirectBidderAccepted(indirectBidderAccepted);

        String indirectBidderTendered = securityObject.get("indirectBidderTendered").getAsString();

        log.debug("indirectBidderTendered: " + indirectBidderTendered);

        result.setIndirectBidderTendered(indirectBidderTendered);

        String interestPaymentFrequency = securityObject.get("interestPaymentFrequency").getAsString();

        log.debug("interestPaymentFrequency: " + interestPaymentFrequency);

        result.setInterestPaymentFrequency(interestPaymentFrequency);

        String lowDiscountRate = securityObject.get("lowDiscountRate").getAsString();

        log.debug("lowDiscountRate: " + lowDiscountRate);

        result.setLowDiscountRate(lowDiscountRate);

        String lowInvestmentRate = securityObject.get("lowInvestmentRate").getAsString();

        log.debug("lowInvestmentRate: " + lowInvestmentRate);

        result.setLowInvestmentRate(lowInvestmentRate);

        String lowPrice = securityObject.get("lowPrice").getAsString();

        log.debug("lowPrice: " + lowPrice);

        result.setLowPrice(lowPrice);

        String lowDiscountMargin = securityObject.get("lowDiscountMargin").getAsString();

        log.debug("lowDiscountMargin: " + lowDiscountMargin);

        result.setLowDiscountMargin(lowDiscountMargin);

        String lowYield = securityObject.get("lowYield").getAsString();

        log.debug("lowYield: " + lowYield);

        result.setLowYield(lowYield);

        String maturingDate = securityObject.get("maturingDate").getAsString();

        log.debug("maturingDate: " + maturingDate);

        result.setMaturingDate(maturingDate);

        String maximumCompetitiveAward = securityObject.get("maximumCompetitiveAward").getAsString();

        log.debug("maximumCompetitiveAward: " + maximumCompetitiveAward);

        result.setMaximumCompetitiveAward(maximumCompetitiveAward);

        String maximumNoncompetitiveAward = securityObject.get("maximumNoncompetitiveAward").getAsString();

        log.debug("maximumNoncompetitiveAward: " + maximumNoncompetitiveAward);

        result.setMaximumNoncompetitiveAward(maximumNoncompetitiveAward);

        String maximumSingleBid = securityObject.get("maximumSingleBid").getAsString();

        log.debug("maximumSingleBid: " + maximumSingleBid);

        result.setMaximumSingleBid(maximumSingleBid);

        String minimumBidAmount = securityObject.get("minimumBidAmount").getAsString();

        log.debug("minimumBidAmount: " + minimumBidAmount);

        result.setMinimumBidAmount(minimumBidAmount);

        String minimumStripAmount = securityObject.get("minimumStripAmount").getAsString();

        log.debug("minimumStripAmount: " + minimumStripAmount);

        result.setMinimumStripAmount(minimumStripAmount);

        String minimumToIssue = securityObject.get("minimumToIssue").getAsString();

        log.debug("minimumToIssue: " + minimumToIssue);

        result.setMinimumToIssue(minimumToIssue);

        String multiplesToBid = securityObject.get("multiplesToBid").getAsString();

        log.debug("multiplesToBid: " + multiplesToBid);

        result.setMultiplesToBid(multiplesToBid);

        String multiplesToIssue = securityObject.get("multiplesToIssue").getAsString();

        log.debug("multiplesToIssue: " + multiplesToIssue);

        result.setMultiplesToIssue(multiplesToIssue);

        String nlpExclusionAmount = securityObject.get("nlpExclusionAmount").getAsString();

        log.debug("nlpExclusionAmount: " + nlpExclusionAmount);

        result.setNlpExclusionAmount(nlpExclusionAmount);

        String nlpReportingThreshold = securityObject.get("nlpReportingThreshold").getAsString();

        log.debug("nlpReportingThreshold: " + nlpReportingThreshold);

        result.setNlpReportingThreshold(nlpReportingThreshold);

        String noncompetitiveAccepted = securityObject.get("noncompetitiveAccepted").getAsString();

        log.debug("noncompetitiveAccepted: " + noncompetitiveAccepted);

        result.setNoncompetitiveAccepted(noncompetitiveAccepted);

        String noncompetitiveTendersAccepted = securityObject.get("noncompetitiveTendersAccepted").getAsString();

        log.debug("noncompetitiveTendersAccepted: " + noncompetitiveTendersAccepted);

        result.setNoncompetitiveTendersAccepted(noncompetitiveTendersAccepted);

        String offeringAmount = securityObject.get("offeringAmount").getAsString();

        log.debug("offeringAmount: " + offeringAmount);

        result.setOfferingAmount(offeringAmount);

        String originalCusip = securityObject.get("originalCusip").getAsString();

        log.debug("originalCusip: " + originalCusip);

        result.setOriginalCusip(originalCusip);

        String originalDatedDate = securityObject.get("originalDatedDate").getAsString();

        log.debug("originalDatedDate: " + originalDatedDate);

        result.setOriginalDatedDate(originalDatedDate);

        String originalIssueDate = securityObject.get("originalIssueDate").getAsString();

        log.debug("originalIssueDate: " + originalIssueDate);

        result.setOriginalIssueDate(originalIssueDate);

        String originalSecurityTerm = securityObject.get("originalSecurityTerm").getAsString();

        log.debug("originalSecurityTerm: " + originalSecurityTerm);

        result.setOriginalSecurityTerm(originalSecurityTerm);

        String pdfFilenameAnnouncement = securityObject.get("pdfFilenameAnnouncement").getAsString();

        log.debug("pdfFilenameAnnouncement: " + pdfFilenameAnnouncement);

        result.setPdfFilenameAnnouncement(pdfFilenameAnnouncement);

        String pdfFilenameCompetitiveResults = securityObject.get("pdfFilenameCompetitiveResults").getAsString();

        log.debug("pdfFilenameCompetitiveResults: " + pdfFilenameCompetitiveResults);

        result.setPdfFilenameCompetitiveResults(pdfFilenameCompetitiveResults);

        String pdfFilenameNoncompetitiveResults = securityObject.get("pdfFilenameNoncompetitiveResults").getAsString();

        log.debug("pdfFilenameNoncompetitiveResults: " + pdfFilenameNoncompetitiveResults);

        result.setPdfFilenameNoncompetitiveResults(pdfFilenameNoncompetitiveResults);

        String pdfFilenameSpecialAnnouncement = securityObject.get("pdfFilenameSpecialAnnouncement").getAsString();

        log.debug("pdfFilenameSpecialAnnouncement: " + pdfFilenameSpecialAnnouncement);

        result.setPdfFilenameSpecialAnnouncement(pdfFilenameSpecialAnnouncement);

        String pricePer100 = securityObject.get("pricePer100").getAsString();

        log.debug("pricePer100: " + pricePer100);

        result.setPricePer100(pricePer100);

        String primaryDealerAccepted = securityObject.get("primaryDealerAccepted").getAsString();

        log.debug("primaryDealerAccepted: " + primaryDealerAccepted);

        result.setPrimaryDealerAccepted(primaryDealerAccepted);

        String primaryDealerTendered = securityObject.get("primaryDealerTendered").getAsString();

        log.debug("primaryDealerTendered: " + primaryDealerTendered);

        result.setPrimaryDealerTendered(primaryDealerTendered);

        String reopening = securityObject.get("reopening").getAsString();

        log.debug("reopening: " + reopening);

        result.setReopening(reopening);

        String securityTermDayMonth = securityObject.get("securityTermDayMonth").getAsString();

        log.debug("securityTermDayMonth: " + securityTermDayMonth);

        result.setSecurityTermDayMonth(securityTermDayMonth);

        String securityTermWeekYear = securityObject.get("securityTermWeekYear").getAsString();

        log.debug("securityTermWeekYear: " + securityTermWeekYear);

        result.setSecurityTermWeekYear(securityTermWeekYear);

        String series = securityObject.get("series").getAsString();

        log.debug("series: " + series);

        result.setSeries(series);

        String somaAccepted = securityObject.get("somaAccepted").getAsString();

        log.debug("somaAccepted: " + somaAccepted);

        result.setSomaAccepted(somaAccepted);

        String somaHoldings = securityObject.get("somaHoldings").getAsString();

        log.debug("somaHoldings: " + somaHoldings);

        result.setSomaHoldings(somaHoldings);

        String somaIncluded = securityObject.get("somaIncluded").getAsString();

        log.debug("somaIncluded: " + somaIncluded);

        result.setSomaIncluded(somaIncluded);

        String somaTendered = securityObject.get("somaTendered").getAsString();

        log.debug("somaTendered: " + somaTendered);

        result.setSomaTendered(somaTendered);

        String spread = securityObject.get("spread").getAsString();

        log.debug("spread: " + spread);

        result.setSpread(spread);

        String standardInterestPaymentPer1000 = securityObject.get("standardInterestPaymentPer1000").getAsString();

        log.debug("standardInterestPaymentPer1000: " + standardInterestPaymentPer1000);

        result.setStandardInterestPaymentPer1000(standardInterestPaymentPer1000);

        String strippable = securityObject.get("strippable").getAsString();

        log.debug("strippable: " + strippable);

        result.setStrippable(strippable);

        String term = securityObject.get("term").getAsString();

        log.debug("term: " + term);

        result.setTerm(term);

        String tiinConversionFactorPer1000 = securityObject.get("tiinConversionFactorPer1000").getAsString();

        log.debug("tiinConversionFactorPer1000: " + tiinConversionFactorPer1000);

        result.setTiinConversionFactorPer1000(tiinConversionFactorPer1000);

        String tips = securityObject.get("tips").getAsString();

        log.debug("tips: " + tips);

        result.setTips(tips);

        String totalAccepted = securityObject.get("totalAccepted").getAsString();

        log.debug("totalAccepted: " + totalAccepted);

        result.setTotalAccepted(totalAccepted);

        String totalTendered = securityObject.get("totalTendered").getAsString();

        log.debug("totalTendered: " + totalTendered);

        result.setTotalTendered(totalTendered);

        String treasuryDirectAccepted = securityObject.get("treasuryDirectAccepted").getAsString();

        log.debug("treasuryDirectAccepted: " + treasuryDirectAccepted);

        result.setTreasuryDirectAccepted(treasuryDirectAccepted);

        String treasuryDirectTendersAccepted = securityObject.get("treasuryDirectTendersAccepted").getAsString();

        log.debug("treasuryDirectTendersAccepted: " + treasuryDirectTendersAccepted);

        result.setTreasuryDirectTendersAccepted(treasuryDirectTendersAccepted);

        String type = securityObject.get("type").getAsString();

        log.debug("type: " + type);

        result.setType(type);

        String unadjustedAccruedInterestPer1000 = securityObject.get("unadjustedAccruedInterestPer1000").getAsString();

        log.debug("unadjustedAccruedInterestPer1000: " + unadjustedAccruedInterestPer1000);

        result.setUnadjustedAccruedInterestPer1000(unadjustedAccruedInterestPer1000);

        String unadjustedPrice = securityObject.get("unadjustedPrice").getAsString();

        log.debug("unadjustedPrice: " + unadjustedPrice);

        result.setUnadjustedPrice(unadjustedPrice);

        String updatedTimestamp = securityObject.get("updatedTimestamp").getAsString();

        log.debug("updatedTimestamp: " + updatedTimestamp);

        result.setUpdatedTimestamp(updatedTimestamp);

        String xmlFilenameAnnouncement = securityObject.get("xmlFilenameAnnouncement").getAsString();

        log.debug("xmlFilenameAnnouncement: " + xmlFilenameAnnouncement);

        result.setXmlFilenameAnnouncement(xmlFilenameAnnouncement);

        String xmlFilenameCompetitiveResults = securityObject.get("xmlFilenameCompetitiveResults").getAsString();

        log.debug("xmlFilenameCompetitiveResults: " + xmlFilenameCompetitiveResults);

        result.setXmlFilenameCompetitiveResults(xmlFilenameCompetitiveResults);

        String xmlFilenameSpecialAnnouncement = securityObject.get("xmlFilenameSpecialAnnouncement").getAsString();

        log.debug("xmlFilenameSpecialAnnouncement: " + xmlFilenameSpecialAnnouncement);

        result.setXmlFilenameSpecialAnnouncement(xmlFilenameSpecialAnnouncement);

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
