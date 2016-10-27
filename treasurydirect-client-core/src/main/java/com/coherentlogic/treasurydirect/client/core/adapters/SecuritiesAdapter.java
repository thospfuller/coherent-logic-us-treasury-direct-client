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
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * 
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

    	log.info("read: method begins; reader: " + reader);

        Securities result = new Securities ();

        JsonElement securitiesElement = null;

        try {
            securitiesElement = getGsonBuilder().create().fromJson(reader, JsonArray.class);
        } catch (JsonSyntaxException jsonSyntaxException) {
            try {
                securitiesElement = getGsonBuilder().create().fromJson(reader, JsonObject.class);
            } catch (Throwable thrown) {
                throw new ConversionFailedException("Unable to convert the JSON into either an array or an object.",
                    thrown);
            }
        }

        if (securitiesElement.isJsonArray()) {

            JsonArray securityArray = securitiesElement.getAsJsonArray();

            List<Security> securityList = asSecurityList (securityArray);

            result.setSecurityList(securityList);

        } else {

            List<Security> securityList = new ArrayList<Security> ();

            Security security = asSecurity(securitiesElement.getAsJsonObject());

            securityList.add(security);
        }

        log.info("read: method ends; result: " + result);

        return result;
    }

    Security asSecurity (JsonObject securityObject) {

        Security result = new Security ();

        String cusip = securityObject.get("cusip").toString();

        log.debug("cusip: " + cusip);

        result.setCusip(cusip);

        String issueDate = securityObject.get("issueDate").toString();

        log.debug("issueDate: " + issueDate);

        result.setIssueDate(issueDate);

        String securityType = securityObject.get("securityType").toString();

        log.debug("securityType: " + securityType);

        result.setSecurityType(securityType);

        String securityTerm = securityObject.get("securityTerm").toString();

        log.debug("securityTerm: " + securityTerm);

        result.setSecurityTerm(securityTerm);

        String maturityDate = securityObject.get("maturityDate").toString();

        log.debug("maturityDate: " + maturityDate);

        result.setMaturityDate(maturityDate);

        String interestRate = securityObject.get("interestRate").toString();

        log.debug("interestRate: " + interestRate);

        result.setInterestRate(interestRate);

        String refCpiOnIssueDate = securityObject.get("refCpiOnIssueDate").toString();

        log.debug("refCpiOnIssueDate: " + refCpiOnIssueDate);

        result.setRefCpiOnIssueDate(refCpiOnIssueDate);

        String refCpiOnDatedDate = securityObject.get("refCpiOnDatedDate").toString();

        log.debug("refCpiOnDatedDate: " + refCpiOnDatedDate);

        result.setRefCpiOnDatedDate(refCpiOnDatedDate);

        String announcementDate = securityObject.get("announcementDate").toString();

        log.debug("announcementDate: " + announcementDate);

        result.setAnnouncementDate(announcementDate);

        String auctionDate = securityObject.get("auctionDate").toString();

        log.debug("auctionDate: " + auctionDate);

        result.setAuctionDate(auctionDate);

        String auctionDateYear = securityObject.get("auctionDateYear").toString();

        log.debug("auctionDateYear: " + auctionDateYear);

        result.setAuctionDateYear(auctionDateYear);

        String datedDate = securityObject.get("datedDate").toString();

        log.debug("datedDate: " + datedDate);

        result.setDatedDate(datedDate);

        String accruedInterestPer1000 = securityObject.get("accruedInterestPer1000").toString();

        log.debug("accruedInterestPer1000: " + accruedInterestPer1000);

        result.setAccruedInterestPer1000(accruedInterestPer1000);

        String accruedInterestPer100 = securityObject.get("accruedInterestPer100").toString();

        log.debug("accruedInterestPer100: " + accruedInterestPer100);

        result.setAccruedInterestPer100(accruedInterestPer100);

        String adjustedAccruedInterestPer1000 = securityObject.get("adjustedAccruedInterestPer1000").toString();

        log.debug("adjustedAccruedInterestPer1000: " + adjustedAccruedInterestPer1000);

        result.setAdjustedAccruedInterestPer1000(adjustedAccruedInterestPer1000);

        String adjustedPrice = securityObject.get("adjustedPrice").toString();

        log.debug("adjustedPrice: " + adjustedPrice);

        result.setAdjustedPrice(adjustedPrice);

        String allocationPercentage = securityObject.get("allocationPercentage").toString();

        log.debug("allocationPercentage: " + allocationPercentage);

        result.setAllocationPercentage(allocationPercentage);

        String allocationPercentageDecimals = securityObject.get("allocationPercentageDecimals").toString();

        log.debug("allocationPercentageDecimals: " + allocationPercentageDecimals);

        result.setAllocationPercentageDecimals(allocationPercentageDecimals);

        String announcedCusip = securityObject.get("announcedCusip").toString();

        log.debug("announcedCusip: " + announcedCusip);

        result.setAnnouncedCusip(announcedCusip);

        String auctionFormat = securityObject.get("auctionFormat").toString();

        log.debug("auctionFormat: " + auctionFormat);

        result.setAuctionFormat(auctionFormat);

        String averageMedianDiscountRate = securityObject.get("averageMedianDiscountRate").toString();

        log.debug("averageMedianDiscountRate: " + averageMedianDiscountRate);

        result.setAverageMedianDiscountRate(averageMedianDiscountRate);

        String averageMedianInvestmentRate = securityObject.get("averageMedianInvestmentRate").toString();

        log.debug("averageMedianInvestmentRate: " + averageMedianInvestmentRate);

        result.setAverageMedianInvestmentRate(averageMedianInvestmentRate);

        String averageMedianPrice = securityObject.get("averageMedianPrice").toString();

        log.debug("averageMedianPrice: " + averageMedianPrice);

        result.setAverageMedianPrice(averageMedianPrice);

        String averageMedianDiscountMargin = securityObject.get("averageMedianDiscountMargin").toString();

        log.debug("averageMedianDiscountMargin: " + averageMedianDiscountMargin);

        result.setAverageMedianDiscountMargin(averageMedianDiscountMargin);

        String averageMedianYield = securityObject.get("averageMedianYield").toString();

        log.debug("averageMedianYield: " + averageMedianYield);

        result.setAverageMedianYield(averageMedianYield);

        String backDated = securityObject.get("backDated").toString();

        log.debug("backDated: " + backDated);

        result.setBackDated(backDated);

        String backDatedDate = securityObject.get("backDatedDate").toString();

        log.debug("backDatedDate: " + backDatedDate);

        result.setBackDatedDate(backDatedDate);

        String bidToCoverRatio = securityObject.get("bidToCoverRatio").toString();

        log.debug("bidToCoverRatio: " + bidToCoverRatio);

        result.setBidToCoverRatio(bidToCoverRatio);

        String callDate = securityObject.get("callDate").toString();

        log.debug("callDate: " + callDate);

        result.setCallDate(callDate);

        String callable = securityObject.get("callable").toString();

        log.debug("callable: " + callable);

        result.setCallable(callable);

        String calledDate = securityObject.get("calledDate").toString();

        log.debug("calledDate: " + calledDate);

        result.setCalledDate(calledDate);

        String cashManagementBillCMB = securityObject.get("cashManagementBillCMB").toString();

        log.debug("cashManagementBillCMB: " + cashManagementBillCMB);

        result.setCashManagementBillCMB(cashManagementBillCMB);

        String closingTimeCompetitive = securityObject.get("closingTimeCompetitive").toString();

        log.debug("closingTimeCompetitive: " + closingTimeCompetitive);

        result.setClosingTimeCompetitive(closingTimeCompetitive);

        String closingTimeNoncompetitive = securityObject.get("closingTimeNoncompetitive").toString();

        log.debug("closingTimeNoncompetitive: " + closingTimeNoncompetitive);

        result.setClosingTimeNoncompetitive(closingTimeNoncompetitive);

        String competitiveAccepted = securityObject.get("competitiveAccepted").toString();

        log.debug("competitiveAccepted: " + competitiveAccepted);

        result.setCompetitiveAccepted(competitiveAccepted);

        String competitiveBidDecimals = securityObject.get("competitiveBidDecimals").toString();

        log.debug("competitiveBidDecimals: " + competitiveBidDecimals);

        result.setCompetitiveBidDecimals(competitiveBidDecimals);

        String competitiveTendered = securityObject.get("competitiveTendered").toString();

        log.debug("competitiveTendered: " + competitiveTendered);

        result.setCompetitiveTendered(competitiveTendered);

        String competitiveTendersAccepted = securityObject.get("competitiveTendersAccepted").toString();

        log.debug("competitiveTendersAccepted: " + competitiveTendersAccepted);

        result.setCompetitiveTendersAccepted(competitiveTendersAccepted);

        String corpusCusip = securityObject.get("corpusCusip").toString();

        log.debug("corpusCusip: " + corpusCusip);

        result.setCorpusCusip(corpusCusip);

        String cpiBaseReferencePeriod = securityObject.get("cpiBaseReferencePeriod").toString();

        log.debug("cpiBaseReferencePeriod: " + cpiBaseReferencePeriod);

        result.setCpiBaseReferencePeriod(cpiBaseReferencePeriod);

        String currentlyOutstanding = securityObject.get("currentlyOutstanding").toString();

        log.debug("currentlyOutstanding: " + currentlyOutstanding);

        result.setCurrentlyOutstanding(currentlyOutstanding);

        String directBidderAccepted = securityObject.get("directBidderAccepted").toString();

        log.debug("directBidderAccepted: " + directBidderAccepted);

        result.setDirectBidderAccepted(directBidderAccepted);

        String directBidderTendered = securityObject.get("directBidderTendered").toString();

        log.debug("directBidderTendered: " + directBidderTendered);

        result.setDirectBidderTendered(directBidderTendered);

        String estimatedAmountOfPubliclyHeldMaturingSecuritiesByType = securityObject.get("estimatedAmountOfPubliclyHeldMaturingSecuritiesByType").toString();

        log.debug("estimatedAmountOfPubliclyHeldMaturingSecuritiesByType: " + estimatedAmountOfPubliclyHeldMaturingSecuritiesByType);

        result.setEstimatedAmountOfPubliclyHeldMaturingSecuritiesByType(estimatedAmountOfPubliclyHeldMaturingSecuritiesByType);

        String fimaIncluded = securityObject.get("fimaIncluded").toString();

        log.debug("fimaIncluded: " + fimaIncluded);

        result.setFimaIncluded(fimaIncluded);

        String fimaNoncompetitiveAccepted = securityObject.get("fimaNoncompetitiveAccepted").toString();

        log.debug("fimaNoncompetitiveAccepted: " + fimaNoncompetitiveAccepted);

        result.setFimaNoncompetitiveAccepted(fimaNoncompetitiveAccepted);

        String fimaNoncompetitiveTendered = securityObject.get("fimaNoncompetitiveTendered").toString();

        log.debug("fimaNoncompetitiveTendered: " + fimaNoncompetitiveTendered);

        result.setFimaNoncompetitiveTendered(fimaNoncompetitiveTendered);

        String firstInterestPeriod = securityObject.get("firstInterestPeriod").toString();

        log.debug("firstInterestPeriod: " + firstInterestPeriod);

        result.setFirstInterestPeriod(firstInterestPeriod);

        String firstInterestPaymentDate = securityObject.get("firstInterestPaymentDate").toString();

        log.debug("firstInterestPaymentDate: " + firstInterestPaymentDate);

        result.setFirstInterestPaymentDate(firstInterestPaymentDate);

        String floatingRate = securityObject.get("floatingRate").toString();

        log.debug("floatingRate: " + floatingRate);

        result.setFloatingRate(floatingRate);

        String frnIndexDeterminationDate = securityObject.get("frnIndexDeterminationDate").toString();

        log.debug("frnIndexDeterminationDate: " + frnIndexDeterminationDate);

        result.setFrnIndexDeterminationDate(frnIndexDeterminationDate);

        String frnIndexDeterminationRate = securityObject.get("frnIndexDeterminationRate").toString();

        log.debug("frnIndexDeterminationRate: " + frnIndexDeterminationRate);

        result.setFrnIndexDeterminationRate(frnIndexDeterminationRate);

        String highDiscountRate = securityObject.get("highDiscountRate").toString();

        log.debug("highDiscountRate: " + highDiscountRate);

        result.setHighDiscountRate(highDiscountRate);

        String highInvestmentRate = securityObject.get("highInvestmentRate").toString();

        log.debug("highInvestmentRate: " + highInvestmentRate);

        result.setHighInvestmentRate(highInvestmentRate);

        String highPrice = securityObject.get("highPrice").toString();

        log.debug("highPrice: " + highPrice);

        result.setHighPrice(highPrice);

        String highDiscountMargin = securityObject.get("highDiscountMargin").toString();

        log.debug("highDiscountMargin: " + highDiscountMargin);

        result.setHighDiscountMargin(highDiscountMargin);

        String highYield = securityObject.get("highYield").toString();

        log.debug("highYield: " + highYield);

        result.setHighYield(highYield);

        String indexRatioOnIssueDate = securityObject.get("indexRatioOnIssueDate").toString();

        log.debug("indexRatioOnIssueDate: " + indexRatioOnIssueDate);

        result.setIndexRatioOnIssueDate(indexRatioOnIssueDate);

        String indirectBidderAccepted = securityObject.get("indirectBidderAccepted").toString();

        log.debug("indirectBidderAccepted: " + indirectBidderAccepted);

        result.setIndirectBidderAccepted(indirectBidderAccepted);

        String indirectBidderTendered = securityObject.get("indirectBidderTendered").toString();

        log.debug("indirectBidderTendered: " + indirectBidderTendered);

        result.setIndirectBidderTendered(indirectBidderTendered);

        String interestPaymentFrequency = securityObject.get("interestPaymentFrequency").toString();

        log.debug("interestPaymentFrequency: " + interestPaymentFrequency);

        result.setInterestPaymentFrequency(interestPaymentFrequency);

        String lowDiscountRate = securityObject.get("lowDiscountRate").toString();

        log.debug("lowDiscountRate: " + lowDiscountRate);

        result.setLowDiscountRate(lowDiscountRate);

        String lowInvestmentRate = securityObject.get("lowInvestmentRate").toString();

        log.debug("lowInvestmentRate: " + lowInvestmentRate);

        result.setLowInvestmentRate(lowInvestmentRate);

        String lowPrice = securityObject.get("lowPrice").toString();

        log.debug("lowPrice: " + lowPrice);

        result.setLowPrice(lowPrice);

        String lowDiscountMargin = securityObject.get("lowDiscountMargin").toString();

        log.debug("lowDiscountMargin: " + lowDiscountMargin);

        result.setLowDiscountMargin(lowDiscountMargin);

        String lowYield = securityObject.get("lowYield").toString();

        log.debug("lowYield: " + lowYield);

        result.setLowYield(lowYield);

        String maturingDate = securityObject.get("maturingDate").toString();

        log.debug("maturingDate: " + maturingDate);

        result.setMaturingDate(maturingDate);

        String maximumCompetitiveAward = securityObject.get("maximumCompetitiveAward").toString();

        log.debug("maximumCompetitiveAward: " + maximumCompetitiveAward);

        result.setMaximumCompetitiveAward(maximumCompetitiveAward);

        String maximumNoncompetitiveAward = securityObject.get("maximumNoncompetitiveAward").toString();

        log.debug("maximumNoncompetitiveAward: " + maximumNoncompetitiveAward);

        result.setMaximumNoncompetitiveAward(maximumNoncompetitiveAward);

        String maximumSingleBid = securityObject.get("maximumSingleBid").toString();

        log.debug("maximumSingleBid: " + maximumSingleBid);

        result.setMaximumSingleBid(maximumSingleBid);

        String minimumBidAmount = securityObject.get("minimumBidAmount").toString();

        log.debug("minimumBidAmount: " + minimumBidAmount);

        result.setMinimumBidAmount(minimumBidAmount);

        String minimumStripAmount = securityObject.get("minimumStripAmount").toString();

        log.debug("minimumStripAmount: " + minimumStripAmount);

        result.setMinimumStripAmount(minimumStripAmount);

        String minimumToIssue = securityObject.get("minimumToIssue").toString();

        log.debug("minimumToIssue: " + minimumToIssue);

        result.setMinimumToIssue(minimumToIssue);

        String multiplesToBid = securityObject.get("multiplesToBid").toString();

        log.debug("multiplesToBid: " + multiplesToBid);

        result.setMultiplesToBid(multiplesToBid);

        String multiplesToIssue = securityObject.get("multiplesToIssue").toString();

        log.debug("multiplesToIssue: " + multiplesToIssue);

        result.setMultiplesToIssue(multiplesToIssue);

        String nlpExclusionAmount = securityObject.get("nlpExclusionAmount").toString();

        log.debug("nlpExclusionAmount: " + nlpExclusionAmount);

        result.setNlpExclusionAmount(nlpExclusionAmount);

        String nlpReportingThreshold = securityObject.get("nlpReportingThreshold").toString();

        log.debug("nlpReportingThreshold: " + nlpReportingThreshold);

        result.setNlpReportingThreshold(nlpReportingThreshold);

        String noncompetitiveAccepted = securityObject.get("noncompetitiveAccepted").toString();

        log.debug("noncompetitiveAccepted: " + noncompetitiveAccepted);

        result.setNoncompetitiveAccepted(noncompetitiveAccepted);

        String noncompetitiveTendersAccepted = securityObject.get("noncompetitiveTendersAccepted").toString();

        log.debug("noncompetitiveTendersAccepted: " + noncompetitiveTendersAccepted);

        result.setNoncompetitiveTendersAccepted(noncompetitiveTendersAccepted);

        String offeringAmount = securityObject.get("offeringAmount").toString();

        log.debug("offeringAmount: " + offeringAmount);

        result.setOfferingAmount(offeringAmount);

        String originalCusip = securityObject.get("originalCusip").toString();

        log.debug("originalCusip: " + originalCusip);

        result.setOriginalCusip(originalCusip);

        String originalDatedDate = securityObject.get("originalDatedDate").toString();

        log.debug("originalDatedDate: " + originalDatedDate);

        result.setOriginalDatedDate(originalDatedDate);

        String originalIssueDate = securityObject.get("originalIssueDate").toString();

        log.debug("originalIssueDate: " + originalIssueDate);

        result.setOriginalIssueDate(originalIssueDate);

        String originalSecurityTerm = securityObject.get("originalSecurityTerm").toString();

        log.debug("originalSecurityTerm: " + originalSecurityTerm);

        result.setOriginalSecurityTerm(originalSecurityTerm);

        String pdfFilenameAnnouncement = securityObject.get("pdfFilenameAnnouncement").toString();

        log.debug("pdfFilenameAnnouncement: " + pdfFilenameAnnouncement);

        result.setPdfFilenameAnnouncement(pdfFilenameAnnouncement);

        String pdfFilenameCompetitiveResults = securityObject.get("pdfFilenameCompetitiveResults").toString();

        log.debug("pdfFilenameCompetitiveResults: " + pdfFilenameCompetitiveResults);

        result.setPdfFilenameCompetitiveResults(pdfFilenameCompetitiveResults);

        String pdfFilenameNoncompetitiveResults = securityObject.get("pdfFilenameNoncompetitiveResults").toString();

        log.debug("pdfFilenameNoncompetitiveResults: " + pdfFilenameNoncompetitiveResults);

        result.setPdfFilenameNoncompetitiveResults(pdfFilenameNoncompetitiveResults);

        String pdfFilenameSpecialAnnouncement = securityObject.get("pdfFilenameSpecialAnnouncement").toString();

        log.debug("pdfFilenameSpecialAnnouncement: " + pdfFilenameSpecialAnnouncement);

        result.setPdfFilenameSpecialAnnouncement(pdfFilenameSpecialAnnouncement);

        String pricePer100 = securityObject.get("pricePer100").toString();

        log.debug("pricePer100: " + pricePer100);

        result.setPricePer100(pricePer100);

        String primaryDealerAccepted = securityObject.get("primaryDealerAccepted").toString();

        log.debug("primaryDealerAccepted: " + primaryDealerAccepted);

        result.setPrimaryDealerAccepted(primaryDealerAccepted);

        String primaryDealerTendered = securityObject.get("primaryDealerTendered").toString();

        log.debug("primaryDealerTendered: " + primaryDealerTendered);

        result.setPrimaryDealerTendered(primaryDealerTendered);

        String reopening = securityObject.get("reopening").toString();

        log.debug("reopening: " + reopening);

        result.setReopening(reopening);

        String securityTermDayMonth = securityObject.get("securityTermDayMonth").toString();

        log.debug("securityTermDayMonth: " + securityTermDayMonth);

        result.setSecurityTermDayMonth(securityTermDayMonth);

        String securityTermWeekYear = securityObject.get("securityTermWeekYear").toString();

        log.debug("securityTermWeekYear: " + securityTermWeekYear);

        result.setSecurityTermWeekYear(securityTermWeekYear);

        String series = securityObject.get("series").toString();

        log.debug("series: " + series);

        result.setSeries(series);

        String somaAccepted = securityObject.get("somaAccepted").toString();

        log.debug("somaAccepted: " + somaAccepted);

        result.setSomaAccepted(somaAccepted);

        String somaHoldings = securityObject.get("somaHoldings").toString();

        log.debug("somaHoldings: " + somaHoldings);

        result.setSomaHoldings(somaHoldings);

        String somaIncluded = securityObject.get("somaIncluded").toString();

        log.debug("somaIncluded: " + somaIncluded);

        result.setSomaIncluded(somaIncluded);

        String somaTendered = securityObject.get("somaTendered").toString();

        log.debug("somaTendered: " + somaTendered);

        result.setSomaTendered(somaTendered);

        String spread = securityObject.get("spread").toString();

        log.debug("spread: " + spread);

        result.setSpread(spread);

        String standardInterestPaymentPer1000 = securityObject.get("standardInterestPaymentPer1000").toString();

        log.debug("standardInterestPaymentPer1000: " + standardInterestPaymentPer1000);

        result.setStandardInterestPaymentPer1000(standardInterestPaymentPer1000);

        String strippable = securityObject.get("strippable").toString();

        log.debug("strippable: " + strippable);

        result.setStrippable(strippable);

        String term = securityObject.get("term").toString();

        log.debug("term: " + term);

        result.setTerm(term);

        String tiinConversionFactorPer1000 = securityObject.get("tiinConversionFactorPer1000").toString();

        log.debug("tiinConversionFactorPer1000: " + tiinConversionFactorPer1000);

        result.setTiinConversionFactorPer1000(tiinConversionFactorPer1000);

        String tips = securityObject.get("tips").toString();

        log.debug("tips: " + tips);

        result.setTips(tips);

        String totalAccepted = securityObject.get("totalAccepted").toString();

        log.debug("totalAccepted: " + totalAccepted);

        result.setTotalAccepted(totalAccepted);

        String totalTendered = securityObject.get("totalTendered").toString();

        log.debug("totalTendered: " + totalTendered);

        result.setTotalTendered(totalTendered);

        String treasuryDirectAccepted = securityObject.get("treasuryDirectAccepted").toString();

        log.debug("treasuryDirectAccepted: " + treasuryDirectAccepted);

        result.setTreasuryDirectAccepted(treasuryDirectAccepted);

        String treasuryDirectTendersAccepted = securityObject.get("treasuryDirectTendersAccepted").toString();

        log.debug("treasuryDirectTendersAccepted: " + treasuryDirectTendersAccepted);

        result.setTreasuryDirectTendersAccepted(treasuryDirectTendersAccepted);

        String type = securityObject.get("type").toString();

        log.debug("type: " + type);

        result.setType(type);

        String unadjustedAccruedInterestPer1000 = securityObject.get("unadjustedAccruedInterestPer1000").toString();

        log.debug("unadjustedAccruedInterestPer1000: " + unadjustedAccruedInterestPer1000);

        result.setUnadjustedAccruedInterestPer1000(unadjustedAccruedInterestPer1000);

        String unadjustedPrice = securityObject.get("unadjustedPrice").toString();

        log.debug("unadjustedPrice: " + unadjustedPrice);

        result.setUnadjustedPrice(unadjustedPrice);

        String updatedTimestamp = securityObject.get("updatedTimestamp").toString();

        log.debug("updatedTimestamp: " + updatedTimestamp);

        result.setUpdatedTimestamp(updatedTimestamp);

        String xmlFilenameAnnouncement = securityObject.get("xmlFilenameAnnouncement").toString();

        log.debug("xmlFilenameAnnouncement: " + xmlFilenameAnnouncement);

        result.setXmlFilenameAnnouncement(xmlFilenameAnnouncement);

        String xmlFilenameCompetitiveResults = securityObject.get("xmlFilenameCompetitiveResults").toString();

        log.debug("xmlFilenameCompetitiveResults: " + xmlFilenameCompetitiveResults);

        result.setXmlFilenameCompetitiveResults(xmlFilenameCompetitiveResults);

        String xmlFilenameSpecialAnnouncement = securityObject.get("xmlFilenameSpecialAnnouncement").toString();

        log.debug("xmlFilenameSpecialAnnouncement: " + xmlFilenameSpecialAnnouncement);

        result.setXmlFilenameSpecialAnnouncement(xmlFilenameSpecialAnnouncement);

        return result;
    }

/*
	"cusip": "912828WK2",
	"issueDate": "2014-01-31T00:00:00",
	"securityType": "Note",
	"securityTerm": "2-Year",
	"maturityDate": "2016-01-31T00:00:00",
	"interestRate": "",
	"refCpiOnIssueDate": "",
	"refCpiOnDatedDate": "",
	"announcementDate": "2014-01-23T00:00:00",
	"auctionDate": "2014-01-29T00:00:00",
	"auctionDateYear": "2014",
	"datedDate": "2014-01-31T00:00:00",
	"accruedInterestPer1000": "",
	"accruedInterestPer100": "",
	"adjustedAccruedInterestPer1000": "",
	"adjustedPrice": "",
	"allocationPercentage": "51.490000",
	"allocationPercentageDecimals": "2",
	"announcedCusip": "",
	"auctionFormat": "Single-Price",
	"averageMedianDiscountRate": "",
	"averageMedianInvestmentRate": "",
	"averageMedianPrice": "",
	"averageMedianDiscountMargin": "0.039000",
	"averageMedianYield": "",
	"backDated": "No",
	"backDatedDate": "",
	"bidToCoverRatio": "5.670000",
	"callDate": "",
	"callable": "No",
	"calledDate": "",
	"cashManagementBillCMB": "No",
	"closingTimeCompetitive": "11:30 AM",
	"closingTimeNoncompetitive": "11:00 AM",
	"competitiveAccepted": "14925524000",
	"competitiveBidDecimals": "3",
	"competitiveTendered": "84923585000",
	"competitiveTendersAccepted": "Yes",
	"corpusCusip": "",
	"cpiBaseReferencePeriod": "",
	"currentlyOutstanding": "",
	"directBidderAccepted": "1335000000",
	"directBidderTendered": "6240000000",
	"estimatedAmountOfPubliclyHeldMaturingSecuritiesByType": "66932000000",
	"fimaIncluded": "Yes",
	"fimaNoncompetitiveAccepted": "0",
	"fimaNoncompetitiveTendered": "0",
	"firstInterestPeriod": "Normal",
	"firstInterestPaymentDate": "2014-04-30T00:00:00",
	"floatingRate": "Yes",
	"frnIndexDeterminationDate": "2014-01-27T00:00:00",
	"frnIndexDeterminationRate": "0.055000",
	"highDiscountRate": "",
	"highInvestmentRate": "",
	"highPrice": "100.000000",
	"highDiscountMargin": "0.045000",
	"highYield": "",
	"indexRatioOnIssueDate": "",
	"indirectBidderAccepted": "5649034000",
	"indirectBidderTendered": "35393585000",
	"interestPaymentFrequency": "Quarterly",
	"lowDiscountRate": "",
	"lowInvestmentRate": "",
	"lowPrice": "",
	"lowDiscountMargin": "0.000000",
	"lowYield": "",
	"maturingDate": "2014-01-31T00:00:00",
	"maximumCompetitiveAward": "5250000000",
	"maximumNoncompetitiveAward": "5000000",
	"maximumSingleBid": "5250000000",
	"minimumBidAmount": "100",
	"minimumStripAmount": "",
	"minimumToIssue": "100",
	"multiplesToBid": "100",
	"multiplesToIssue": "100",
	"nlpExclusionAmount": "0",
	"nlpReportingThreshold": "5250000000",
	"noncompetitiveAccepted": "74547200",
	"noncompetitiveTendersAccepted": "Yes",
	"offeringAmount": "15000000000",
	"originalCusip": "",
	"originalDatedDate": "",
	"originalIssueDate": "",
	"originalSecurityTerm": "2-Year",
	"pdfFilenameAnnouncement": "A_20140123_3.pdf",
	"pdfFilenameCompetitiveResults": "R_20140129_1.pdf",
	"pdfFilenameNoncompetitiveResults": "NCR_20140129_1.pdf",
	"pdfFilenameSpecialAnnouncement": "",
	"pricePer100": "100.000000",
	"primaryDealerAccepted": "7941490000",
	"primaryDealerTendered": "43290000000",
	"reopening": "No",
	"securityTermDayMonth": "0-Month",
	"securityTermWeekYear": "2-Year",
	"series": "AV-2016",
	"somaAccepted": "0",
	"somaHoldings": "1000000",
	"somaIncluded": "No",
	"somaTendered": "0",
	"spread": "0.0450",
	"standardInterestPaymentPer1000": "",
	"strippable": "No",
	"term": "2-Year",
	"tiinConversionFactorPer1000": "",
	"tips": "No",
	"totalAccepted": "15000071200",
	"totalTendered": "84998132200",
	"treasuryDirectAccepted": "14940200",
	"treasuryDirectTendersAccepted": "Yes",
	"type": "FRN",
	"unadjustedAccruedInterestPer1000": "",
	"unadjustedPrice": "",
	"updatedTimestamp": "2014-03-07T12:05:06",
	"xmlFilenameAnnouncement": "A_20140123_3.xml",
	"xmlFilenameCompetitiveResults": "R_20140129_1.xml",
	"xmlFilenameSpecialAnnouncement": ""
 */

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

//DataEntry result = getEntryFactory().getInstance();
//
//JsonObject dataEntryObject = gsonBuilder.create().fromJson(reader, JsonObject.class);
//
//JsonElement figi = dataEntryObject.get(FIGI);
//
//result.setFigi(getAsString (FIGI, figi));
//
//JsonElement securityType = dataEntryObject.get(SECURITY_TYPE);
//
//result.setSecurityType(getAsString (SECURITY_TYPE, securityType));
//
//JsonElement marketSector = dataEntryObject.get(MARKET_SECTOR);
//
//result.setMarketSector(getAsString (MARKET_SECTOR, marketSector));
//
//JsonElement ticker = dataEntryObject.get(TICKER);
//
//result.setTicker(getAsString (TICKER, ticker));
//
//JsonElement name = dataEntryObject.get(NAME);
//
//result.setName(getAsString (NAME, name));
//
//JsonElement uniqueID = dataEntryObject.get(UNIQUE_ID);
//
//result.setUniqueID(getAsString (UNIQUE_ID, uniqueID));
//
//JsonElement exchangeCode = dataEntryObject.get(EXCH_CODE);
//
//result.setExchangeCode(getAsString (EXCH_CODE, exchangeCode));
//
//JsonElement shareClassFIGI = dataEntryObject.get(SHARE_CLASS_FIGI);
//
//result.setShareClassFIGI(getAsString (SHARE_CLASS_FIGI, shareClassFIGI));
//
//JsonElement compositeFigi = dataEntryObject.get(COMPOSIT_FIGI);
//
//result.setCompositeFIGI(getAsString (COMPOSIT_FIGI, compositeFigi));
//
//JsonElement uniqueIDFutOptElement = dataEntryObject.get(UNIQUE_ID_FUT_OPT);
//
//result.setUniqueIDForFutureOption(getAsString (UNIQUE_ID_FUT_OPT, uniqueIDFutOptElement));
//
//return result;