package jp.co.yahoo.ad_api_sample.adSample;

import jp.co.yahoo.ad_api_sample.adCustomizerSample.FeedFolderServiceSample;
import jp.co.yahoo.ad_api_sample.error.impl.CampaignServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.v201808.Error;
import jp.yahooapis.ss.v201808.Paging;
import jp.yahooapis.ss.v201808.biddingstrategy.BiddingStrategyOperation;
import jp.yahooapis.ss.v201808.biddingstrategy.BiddingStrategyValues;
import jp.yahooapis.ss.v201808.campaign.AdServingOptimizationStatus;
import jp.yahooapis.ss.v201808.campaign.AppStore;
import jp.yahooapis.ss.v201808.campaign.BiddingStrategyType;
import jp.yahooapis.ss.v201808.campaign.Budget;
import jp.yahooapis.ss.v201808.campaign.BudgetDeliveryMethod;
import jp.yahooapis.ss.v201808.campaign.BudgetOptimizerBiddingScheme;
import jp.yahooapis.ss.v201808.campaign.BudgetPeriod;
import jp.yahooapis.ss.v201808.campaign.Campaign;
import jp.yahooapis.ss.v201808.campaign.CampaignBiddingStrategy;
import jp.yahooapis.ss.v201808.campaign.CampaignOperation;
import jp.yahooapis.ss.v201808.campaign.CampaignPage;
import jp.yahooapis.ss.v201808.campaign.CampaignReturnValue;
import jp.yahooapis.ss.v201808.campaign.CampaignSelector;
import jp.yahooapis.ss.v201808.campaign.CampaignService;
import jp.yahooapis.ss.v201808.campaign.CampaignServiceInterface;
import jp.yahooapis.ss.v201808.campaign.CampaignSettings;
import jp.yahooapis.ss.v201808.campaign.CampaignType;
import jp.yahooapis.ss.v201808.campaign.CampaignValues;
import jp.yahooapis.ss.v201808.campaign.CustomParameter;
import jp.yahooapis.ss.v201808.campaign.CustomParameters;
import jp.yahooapis.ss.v201808.campaign.DynamicAdsForSearchSetting;
import jp.yahooapis.ss.v201808.campaign.EnhancedCpcBiddingScheme;
import jp.yahooapis.ss.v201808.campaign.GeoTargetType;
import jp.yahooapis.ss.v201808.campaign.GeoTargetTypeSetting;
import jp.yahooapis.ss.v201808.campaign.ManualCpcBiddingScheme;
import jp.yahooapis.ss.v201808.campaign.Operator;
import jp.yahooapis.ss.v201808.campaign.PageOnePromotedBiddingScheme;
import jp.yahooapis.ss.v201808.campaign.ReviewUrl;
import jp.yahooapis.ss.v201808.campaign.SettingType;
import jp.yahooapis.ss.v201808.campaign.TargetAll;
import jp.yahooapis.ss.v201808.campaign.TargetCpaBiddingScheme;
import jp.yahooapis.ss.v201808.campaign.TargetRoasBiddingScheme;
import jp.yahooapis.ss.v201808.campaign.TargetSpendBiddingScheme;
import jp.yahooapis.ss.v201808.campaign.TargetingSetting;
import jp.yahooapis.ss.v201808.campaign.UrlApprovalStatus;
import jp.yahooapis.ss.v201808.campaign.UrlReviewData;
import jp.yahooapis.ss.v201808.campaign.UserStatus;
import jp.yahooapis.ss.v201808.feedfolder.FeedFolderOperation;
import jp.yahooapis.ss.v201808.feedfolder.FeedFolderPlaceholderType;
import jp.yahooapis.ss.v201808.feedfolder.FeedFolderValues;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * Sample Program for CampaignService. Copyright (C) 2012 Yahoo Japan Corporation. All Rights
 * Reserved.
 */
public class CampaignServiceSample {

  /**
   * main method for CampaignServiceSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {
    try {
      // =================================================================
      // Setting
      // =================================================================
      long accountId = SoapUtils.getAccountId();
      long biddingStrategyId = SoapUtils.getBiddingStrategyId();

      // =================================================================
      // BiddingStrategyService::ADD
      // =================================================================
      List<BiddingStrategyValues> biddingStrategyValues = null;
      if (biddingStrategyId == 9999999999l) {
        BiddingStrategyOperation addBiddingStrategyOperation = BiddingStrategyServiceSample.createSampleAddRequest(accountId);
        biddingStrategyValues = BiddingStrategyServiceSample.mutate(addBiddingStrategyOperation);
        for (BiddingStrategyValues value : biddingStrategyValues) {
          if (value.getBiddingStrategy().getBiddingScheme() instanceof jp.yahooapis.ss.v201808.biddingstrategy.PageOnePromotedBiddingScheme) {
            biddingStrategyId = value.getBiddingStrategy().getBiddingStrategyId();
          }
        }

        // sleep 30 second.
        System.out.println("\n***** sleep 30 seconds *****\n");
        Thread.sleep(30000);
      }

      // =================================================================
      // FeedFolderService::ADD For Das
      // =================================================================
      long feedFolderId = -1L;
      FeedFolderOperation addFeedFolderOperation = FeedFolderServiceSample.createSampleDasAddRequest(null, accountId);

      List<FeedFolderValues> feedFolderValues = FeedFolderServiceSample.add(addFeedFolderOperation);
      for(FeedFolderValues values: feedFolderValues) {
        if(values.getFeedFolder().getPlaceholderType().equals(FeedFolderPlaceholderType.DYNAMIC_AD_FOR_SEARCH_PAGE_FEEDS)) {
          feedFolderId = values.getFeedFolder().getFeedFolderId();
        }
      }

      // =================================================================
      // CampaignService::ADD
      // =================================================================
      // Set Operation
      CampaignOperation addCampaignOperation = createSampleAddRequest(accountId, biddingStrategyId);
      addCampaignOperation =  createSampleDasAddRequest(addCampaignOperation, accountId, feedFolderId);

      // Run
      List<CampaignValues> addCampaignValues = add(addCampaignOperation);

      boolean allApproved = true;
      // call 30sec sleep * 30 = 15minute
      for (int i = 0; i < 30; i++) {
        // sleep 30 second.
        System.out.println("\n***** sleep 30 seconds for Get Campaign  *****\n");
        Thread.sleep(30000);

        // =================================================================
        // CampaignService::GET
        // =================================================================
        // Set Selector
        CampaignSelector campaignSelector = createSampleGetRequest(accountId, addCampaignValues);

        // Run
        List<CampaignValues> getCampaignValues = get(campaignSelector);

        allApproved = true;
        for (CampaignValues campaignValues : getCampaignValues) {
          if (!UrlApprovalStatus.APPROVED.equals(campaignValues.getCampaign().getUrlReviewData().getUrlApprovalStatus())
              && !UrlApprovalStatus.NONE.equals(campaignValues.getCampaign().getUrlReviewData().getUrlApprovalStatus())) {
            allApproved = false;
          } else if(UrlApprovalStatus.DISAPPROVED.equals(campaignValues.getCampaign().getUrlReviewData().getUrlApprovalStatus())){
            System.out.println("Error : This campaign was denied.");
            campaignValues.getCampaign().getUrlReviewData().getDisapprovalReasonCodes().stream().forEach(
                disapprovalReasonCode -> System.out.println("disapprovalReasonCode:[" + disapprovalReasonCode + "]")
            );

          }
        }
        if (allApproved) {
          break;
        }
      }

      if (!allApproved) {

        // =================================================================
        // CampaignService::REMOVE
        // =================================================================
        // Set Operation
        CampaignOperation removeCampaignOperation = createSampleRemoveRequest(accountId, addCampaignValues);
        // Run
        remove(removeCampaignOperation);

        // =================================================================
        // remove FeedFolderService
        // =================================================================
        // Set Operation
        FeedFolderOperation removeFeedFolderOperation = FeedFolderServiceSample.createSampleRemoveRequest(accountId, feedFolderValues);
        // Run
        FeedFolderServiceSample.remove(removeFeedFolderOperation);

        // =================================================================
        // remove BiddingStrategy
        // =================================================================
        if (biddingStrategyValues != null) {
          BiddingStrategyOperation removeBiddingStrategyOperation = BiddingStrategyServiceSample.createSampleRemoveRequest(accountId, biddingStrategyValues);
          // Run
          BiddingStrategyServiceSample.mutate(removeBiddingStrategyOperation);
        }

        System.exit(5);
      } else {
        // =================================================================
        // CampaignService::SET
        // =================================================================
        // Set Operation
        CampaignOperation setCampaignOperation = createSampleSetRequest(accountId, biddingStrategyId, addCampaignValues);

        // Run
        set(setCampaignOperation);
      }

      // =================================================================
      // CampaignService::REMOVE
      // =================================================================
      // Set Operation
      CampaignOperation removeCampaignOperation = createSampleRemoveRequest(accountId, addCampaignValues);

      // Run
      remove(removeCampaignOperation);

      // =================================================================
      // remove FeedFolderService
      // =================================================================
      FeedFolderOperation removeFeedFolderOperation = FeedFolderServiceSample.createSampleRemoveRequest(accountId, feedFolderValues);
      FeedFolderServiceSample.remove(removeFeedFolderOperation);

      // =================================================================
      // remove BiddingStrategy
      // =================================================================
      if (biddingStrategyValues != null) {
        BiddingStrategyOperation removeBiddingStrategyOperation = BiddingStrategyServiceSample.createSampleRemoveRequest(accountId, biddingStrategyValues);
        BiddingStrategyServiceSample.mutate(removeBiddingStrategyOperation);
      }
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * Sample Program for CampaignService ADD.
   *
   * @param operation CampaignOperation
   * @return CampaignValues
   */
  public static List<CampaignValues> add(CampaignOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("CampaignService::mutate(ADD)");
    System.out.println("############################################");

    Holder<CampaignReturnValue> campaignReturnValueHolder = new Holder<CampaignReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    CampaignServiceInterface campaignService = SoapUtils.createServiceInterface(CampaignServiceInterface.class, CampaignService.class);
    campaignService.mutate(operation, campaignReturnValueHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new CampaignServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (campaignReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:CampaignService Add");
    }

    // Display
    for (CampaignValues campaignValues : campaignReturnValueHolder.value.getValues()) {
      if (campaignValues.isOperationSucceeded()) {
        display(campaignValues.getCampaign());
      } else {
        SoapUtils.displayErrors(new CampaignServiceErrorEntityFactory(campaignValues.getError()), true);
      }
    }

    // Response
    return campaignReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for CampaignService SET.
   *
   * @param operation CampaignOperation
   * @return CampaignValues
   */
  public static List<CampaignValues> set(CampaignOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("CampaignService::mutate(SET)");
    System.out.println("############################################");

    Holder<CampaignReturnValue> campaignReturnValueHolder = new Holder<CampaignReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    CampaignServiceInterface campaignService = SoapUtils.createServiceInterface(CampaignServiceInterface.class, CampaignService.class);
    campaignService.mutate(operation, campaignReturnValueHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new CampaignServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (campaignReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:CampaignService Set");
    }

    // Display
    for (CampaignValues campaignValues : campaignReturnValueHolder.value.getValues()) {
      if (campaignValues.isOperationSucceeded()) {
        display(campaignValues.getCampaign());
      } else {
        SoapUtils.displayErrors(new CampaignServiceErrorEntityFactory(campaignValues.getError()), true);
      }
    }

    // Response
    return campaignReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for CampaignService REMOVE.
   *
   * @param operation CampaignOperation
   * @return CampaignValues
   */
  public static List<CampaignValues> remove(CampaignOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("CampaignService::mutate(REMOVE)");
    System.out.println("############################################");

    Holder<CampaignReturnValue> campaignReturnValueHolder = new Holder<CampaignReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    CampaignServiceInterface campaignService = SoapUtils.createServiceInterface(CampaignServiceInterface.class, CampaignService.class);
    campaignService.mutate(operation, campaignReturnValueHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new CampaignServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (campaignReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:CampaignService Remove");
    }

    // Display
    for (CampaignValues campaignValues : campaignReturnValueHolder.value.getValues()) {
      if (campaignValues.isOperationSucceeded()) {
        display(campaignValues.getCampaign());
      } else {
        SoapUtils.displayErrors(new CampaignServiceErrorEntityFactory(campaignValues.getError()), true);
      }
    }

    // Response
    return campaignReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for CampaignService GET.
   *
   * @param selector CampaignSelector
   * @return CampaignValues
   */
  public static List<CampaignValues> get(CampaignSelector selector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("CampaignService::get");
    System.out.println("############################################");

    Holder<CampaignPage> campaignPageHolder = new Holder<CampaignPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    CampaignServiceInterface CampaignService = SoapUtils.createServiceInterface(CampaignServiceInterface.class, CampaignService.class);
    CampaignService.get(selector, campaignPageHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new CampaignServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (campaignPageHolder.value == null) {
      throw new Exception("NoDataResponse:CampaignService Get");
    }

    // Display
    for (CampaignValues CampaignValues : campaignPageHolder.value.getValues()) {
      if (CampaignValues.isOperationSucceeded()) {
        display(CampaignValues.getCampaign());
      } else {
        SoapUtils.displayErrors(new CampaignServiceErrorEntityFactory(CampaignValues.getError()), true);
      }
    }

    // Response
    return campaignPageHolder.value.getValues();
  }

  /**
   * display Campaign entity to stdout.
   *
   * @param campaign Campaign entity for display.
   */
  public static void display(Campaign campaign) {

    System.out.println("accountId = " + campaign.getAccountId());
    System.out.println("campaignId = " + campaign.getCampaignId());
    System.out.println("campaignTrackId = " + campaign.getCampaignTrackId());
    System.out.println("campaignName = " + campaign.getCampaignName());
    System.out.println("userStatus = " + campaign.getUserStatus());
    System.out.println("startDate = " + campaign.getStartDate());
    System.out.println("endDate = " + campaign.getEndDate());
    if (campaign.getBudget() != null) {
      System.out.println("budget/period = " + campaign.getBudget().getPeriod());
      System.out.println("budget/amount = " + campaign.getBudget().getAmount());
      System.out.println("budget/deliveryMethod = " + campaign.getBudget().getDeliveryMethod());
    }
    if (campaign.getBiddingStrategyConfiguration() != null) {
      System.out.println("biddingStrategyConfiguration/biddingStrategyId = " + campaign.getBiddingStrategyConfiguration().getBiddingStrategyId());
      System.out.println("biddingStrategyConfiguration/biddingStrategyName = " + campaign.getBiddingStrategyConfiguration().getBiddingStrategyName());
      System.out.println("biddingStrategyConfiguration/biddingStrategyType = " + campaign.getBiddingStrategyConfiguration().getBiddingStrategyType());
      System.out.println("biddingStrategyConfiguration/biddingStrategySource = " + campaign.getBiddingStrategyConfiguration().getBiddingStrategySource());

      if (campaign.getBiddingStrategyConfiguration().getBiddingScheme() instanceof EnhancedCpcBiddingScheme) {
        EnhancedCpcBiddingScheme enhancedCpcBiddingScheme = (EnhancedCpcBiddingScheme) campaign.getBiddingStrategyConfiguration().getBiddingScheme();
        System.out.println("biddingStrategyConfiguration/biddingScheme(EnhancedCpcBiddingScheme)/biddingStrategyType = " + enhancedCpcBiddingScheme.getBiddingStrategyType());
      } else if (campaign.getBiddingStrategyConfiguration().getBiddingScheme() instanceof PageOnePromotedBiddingScheme) {
        PageOnePromotedBiddingScheme pageOnePromotedBiddingScheme = (PageOnePromotedBiddingScheme) campaign.getBiddingStrategyConfiguration().getBiddingScheme();
        System.out.println("biddingStrategyConfiguration/biddingScheme(PageOnePromotedBiddingScheme)/biddingStrategyType = " + pageOnePromotedBiddingScheme.getBiddingStrategyType());
        System.out.println("biddingStrategyConfiguration/biddingScheme(PageOnePromotedBiddingScheme)/bidCeiling = " + pageOnePromotedBiddingScheme.getBidCeiling());
        System.out.println("biddingStrategyConfiguration/biddingScheme(PageOnePromotedBiddingScheme)/bidMultiplier = " + pageOnePromotedBiddingScheme.getBidMultiplier());
        System.out.println("biddingStrategyConfiguration/biddingScheme(PageOnePromotedBiddingScheme)/bidChangesForRaisesOnly = " + pageOnePromotedBiddingScheme.getBidChangesForRaisesOnly());
        System.out.println("biddingStrategyConfiguration/biddingScheme(PageOnePromotedBiddingScheme)/raiseBidWhenBudgetConstrained = "
            + pageOnePromotedBiddingScheme.getRaiseBidWhenBudgetConstrained());
        System.out.println("biddingStrategyConfiguration/biddingScheme(PageOnePromotedBiddingScheme)/raiseBidWhenLowQualityScore = " + pageOnePromotedBiddingScheme.getRaiseBidWhenLowQualityScore());
      } else if (campaign.getBiddingStrategyConfiguration().getBiddingScheme() instanceof TargetCpaBiddingScheme) {
        TargetCpaBiddingScheme targetCpaBiddingScheme = (TargetCpaBiddingScheme) campaign.getBiddingStrategyConfiguration().getBiddingScheme();
        System.out.println("biddingStrategyConfiguration/biddingScheme(TargetCpaBiddingScheme)/biddingStrategyType = " + targetCpaBiddingScheme.getBiddingStrategyType());
        System.out.println("biddingStrategyConfiguration/biddingScheme(TargetCpaBiddingScheme)/targetCpa = " + targetCpaBiddingScheme.getTargetCpa());
        System.out.println("biddingStrategyConfiguration/biddingScheme(TargetCpaBiddingScheme)/bidCeiling = " + targetCpaBiddingScheme.getBidCeiling());
        System.out.println("biddingStrategyConfiguration/biddingScheme(TargetCpaBiddingScheme)/bidFloor = " + targetCpaBiddingScheme.getBidFloor());
      } else if (campaign.getBiddingStrategyConfiguration().getBiddingScheme() instanceof TargetSpendBiddingScheme) {
        TargetSpendBiddingScheme targetSpendBiddingScheme = (TargetSpendBiddingScheme) campaign.getBiddingStrategyConfiguration().getBiddingScheme();
        System.out.println("biddingStrategyConfiguration/biddingScheme(TargetSpendBiddingScheme)/biddingStrategyType = " + targetSpendBiddingScheme.getBiddingStrategyType());
        System.out.println("biddingStrategyConfiguration/biddingScheme(TargetSpendBiddingScheme)/bidCeiling = " + targetSpendBiddingScheme.getBidCeiling());
        System.out.println("biddingStrategyConfiguration/biddingScheme(TargetSpendBiddingScheme)/spendTarget = " + targetSpendBiddingScheme.getSpendTarget());
      } else if (campaign.getBiddingStrategyConfiguration().getBiddingScheme() instanceof TargetRoasBiddingScheme) {
        TargetRoasBiddingScheme targetRoasBiddingScheme = (TargetRoasBiddingScheme) campaign.getBiddingStrategyConfiguration().getBiddingScheme();
        System.out.println("biddingStrategyConfiguration/biddingScheme(TargetRoasBiddingScheme)/biddingStrategyType = " + targetRoasBiddingScheme.getBiddingStrategyType());
        System.out.println("biddingStrategyConfiguration/biddingScheme(TargetRoasBiddingScheme)/targetRoas = " + targetRoasBiddingScheme.getTargetRoas());
        System.out.println("biddingStrategyConfiguration/biddingScheme(TargetRoasBiddingScheme)/bidCeiling = " + targetRoasBiddingScheme.getBidCeiling());
        System.out.println("biddingStrategyConfiguration/biddingScheme(TargetRoasBiddingScheme)/bidFloor = " + targetRoasBiddingScheme.getBidFloor());
      } else if (campaign.getBiddingStrategyConfiguration().getBiddingScheme() instanceof ManualCpcBiddingScheme) {
        ManualCpcBiddingScheme manualCpcBiddingScheme = (ManualCpcBiddingScheme) campaign.getBiddingStrategyConfiguration().getBiddingScheme();
        System.out.println("biddingStrategyConfiguration/biddingScheme(ManualCpcBiddingScheme)/biddingStrategyType = " + manualCpcBiddingScheme.getBiddingStrategyType());
      } else if (campaign.getBiddingStrategyConfiguration().getBiddingScheme() instanceof BudgetOptimizerBiddingScheme) {
        BudgetOptimizerBiddingScheme budgetOptimizerBiddingScheme = (BudgetOptimizerBiddingScheme) campaign.getBiddingStrategyConfiguration().getBiddingScheme();
        System.out.println("biddingStrategyConfiguration/biddingScheme(BudgetOptimizerBiddingScheme)/biddingStrategyType = " + budgetOptimizerBiddingScheme.getBiddingStrategyType());
        System.out.println("biddingStrategyConfiguration/biddingScheme(BudgetOptimizerBiddingScheme)/bidCeiling = " + budgetOptimizerBiddingScheme.getBidCeiling());
      }
    }

    System.out.println("conversionOptimizerEligibility = " + campaign.getConversionOptimizerEligibility());
    System.out.println("adServingOptimizationStatus = " + campaign.getAdServingOptimizationStatus());

    if (campaign.getSettings() != null) {
      for (CampaignSettings settings : campaign.getSettings()) {
        if (settings instanceof GeoTargetTypeSetting) {
          System.out.println("settings(GeoTargetTypeSetting)/type = " + settings.getType());
          GeoTargetTypeSetting geoTargetTypeSetting = (GeoTargetTypeSetting) settings;
          System.out.println("settings(GeoTargetTypeSetting)/positiveGeoTargetType = " + geoTargetTypeSetting.getPositiveGeoTargetType());
          System.out.println("settings(GeoTargetTypeSetting)/negativeGeoTargetType = " + geoTargetTypeSetting.getNegativeGeoTargetType());

        } else if (settings instanceof TargetingSetting) {
          System.out.println("settings(TargetingSetting)/type = " + settings.getType());
          TargetingSetting targetingSetting = (TargetingSetting) settings;
          System.out.println("settings(TargetingSetting)/targetAll = " + targetingSetting.getTargetAll());

        } else if (settings instanceof DynamicAdsForSearchSetting) {
          System.out.println("settings(DynamicAdsForSearchSetting)/type = " + settings.getType());
          DynamicAdsForSearchSetting dynamicAdsForSearchSetting = (DynamicAdsForSearchSetting) settings;
          if(null != dynamicAdsForSearchSetting.getFeedFolderIds()) {
            int index = 0;
            for(long feedFolderId: dynamicAdsForSearchSetting.getFeedFolderIds()) {
              System.out.println("settings(DynamicAdsForSearchSetting)/feedFolderIds[" + index + "] = " + feedFolderId);
              index++;
            }
          }

        }
      }
    }

    System.out.println("campaignType = " + campaign.getCampaignType());
    System.out.println("appStore = " + campaign.getAppStore());
    System.out.println("appId = " + campaign.getAppId());

    System.out.println("trackingUrl = " + campaign.getTrackingUrl());
    if (null != campaign.getCustomParameters()) {
      CustomParameters customParameters = campaign.getCustomParameters();
      System.out.println("customParameters/isRemove = " + customParameters.getIsRemove());

      if (null != customParameters.getParameters()) {
        int index = 0;
        for (CustomParameter parameter : customParameters.getParameters()) {
          System.out.println("customParameters/parameters[" + index + "]/key = " + parameter.getKey());
          System.out.println("customParameters/parameters[" + index + "]/value = " + parameter.getValue());
          index++;
        }
      }
    }

    if (null != campaign.getUrlReviewData()) {
      UrlReviewData urlReviewData = campaign.getUrlReviewData();
      if (null != urlReviewData.getInReviewUrl()) {
        ReviewUrl inReviewUrl = urlReviewData.getInReviewUrl();
        if (null != inReviewUrl) {
          System.out.println("urlReviewData/inReviewUrl/trackingUrl = " + inReviewUrl.getTrackingUrl());
          if (null != inReviewUrl.getParameters()) {
            int index = 0;
            for (CustomParameter parameter : inReviewUrl.getParameters()) {
              System.out.println("urlReviewData/inReviewUrl/parameters[" + index + "]/key = " + parameter.getKey());
              System.out.println("urlReviewData/inReviewUrl/parameters[" + index + "]/value = " + parameter.getValue());
              index++;
            }
          }
        }
      }

      if (null != urlReviewData.getInReviewUrl()) {
        ReviewUrl disapprovalReviewUrl = urlReviewData.getDisapprovalReviewUrl();
        if (null != disapprovalReviewUrl) {
          System.out.println("urlReviewData/disapprovalReviewUrl/trackingUrl = " + disapprovalReviewUrl.getTrackingUrl());
          if (null != disapprovalReviewUrl.getParameters()) {
            int index = 0;
            for (CustomParameter parameter : disapprovalReviewUrl.getParameters()) {
              System.out.println("urlReviewData/disapprovalReviewUrl/parameters[" + index + "]/key = " + parameter.getKey());
              System.out.println("urlReviewData/disapprovalReviewUrl/parameters[" + index + "]/value = " + parameter.getValue());
              index++;
            }
          }
        }
      }

      System.out.println("urlReviewData/urlApprovalStatus = " + urlReviewData.getUrlApprovalStatus());

      if (null != urlReviewData.getDisapprovalReasonCodes()) {
        for (String disapprovalReasonCode : urlReviewData.getDisapprovalReasonCodes()) {
          System.out.println("urlReviewData/disapprovalReasonCodes = " + disapprovalReasonCode);
        }
      }

    }

    System.out.println("---------");
  }

  /**
   * create sample request.
   *
   * @param accountId         long
   * @param biddingStrategyId long
   * @return CampaignOperation
   */
  public static CampaignOperation createSampleAddRequest(long accountId, long biddingStrategyId) {
    // Set Operation
    CampaignOperation operation = new CampaignOperation();
    operation.setOperator(Operator.ADD);
    operation.setAccountId(accountId);

    // Set Budget
    Budget budget = new Budget();
    budget.setPeriod(BudgetPeriod.DAILY);
    budget.setAmount((long) 1000);
    budget.setDeliveryMethod(BudgetDeliveryMethod.STANDARD);

    // Set GeoTargetTypeSetting
    GeoTargetTypeSetting geoTargetTypeSetting = new GeoTargetTypeSetting();
    geoTargetTypeSetting.setType(SettingType.GEO_TARGET_TYPE_SETTING);
    geoTargetTypeSetting.setPositiveGeoTargetType(GeoTargetType.AREA_OF_INTENT);
    geoTargetTypeSetting.setNegativeGeoTargetType(GeoTargetType.LOCATION_OF_PRESENCE);

    // Set TargetingSetting
    TargetingSetting targetingSetting = new TargetingSetting();
    targetingSetting.setType(SettingType.TARGET_LIST_SETTING);
    targetingSetting.setTargetAll(TargetAll.ACTIVE);

    // Set AutoBidding
    CampaignBiddingStrategy autoBiddingStrategy = new CampaignBiddingStrategy();
    autoBiddingStrategy.setBiddingStrategyId(biddingStrategyId);

    // Set ManualCpc
    CampaignBiddingStrategy manualCpcStrategy = new CampaignBiddingStrategy();
    manualCpcStrategy.setBiddingStrategyType(BiddingStrategyType.MANUAL_CPC);

    // Set CustomParameters
    CustomParameters customParameters = new CustomParameters();
    CustomParameter parameter1 = new CustomParameter();
    parameter1.setKey("id1");
    parameter1.setValue("1234");
    customParameters.getParameters().addAll(Arrays.asList(parameter1));

    // Set AutoBidding Campaign
    Campaign autoBiddingCampaign = new Campaign();
    autoBiddingCampaign.setAccountId(accountId);
    autoBiddingCampaign.setCampaignName("SampleAutoBiddingCampaign_CreateOn_" + SoapUtils.getCurrentTimestamp());
    autoBiddingCampaign.setUserStatus(UserStatus.ACTIVE);
    autoBiddingCampaign.setStartDate(DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now()));
    autoBiddingCampaign.setEndDate(DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now().plusMonths(1L)));
    autoBiddingCampaign.setBudget(budget);
    autoBiddingCampaign.setBiddingStrategyConfiguration(autoBiddingStrategy);
    autoBiddingCampaign.setAdServingOptimizationStatus(AdServingOptimizationStatus.CONVERSION_OPTIMIZE);
    autoBiddingCampaign.getSettings().add(geoTargetTypeSetting);
    autoBiddingCampaign.getSettings().add(targetingSetting);
    autoBiddingCampaign.setCampaignType(CampaignType.STANDARD);

    autoBiddingCampaign.setTrackingUrl("http://yahoo.co.jp?url={lpurl}&amp;a={creative}&amp;pid={_id1}");
    autoBiddingCampaign.setCustomParameters(customParameters);


    // Set ManualCpc Campaign
    Campaign manualCpcCampaign = new Campaign();
    manualCpcCampaign.setAccountId(accountId);
    manualCpcCampaign.setCampaignName("SampleManualCpcCampaign_CreateOn_" + SoapUtils.getCurrentTimestamp());
    manualCpcCampaign.setUserStatus(UserStatus.ACTIVE);
    manualCpcCampaign.setStartDate(DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now()));
    manualCpcCampaign.setEndDate(DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now().plusMonths(1L)));
    manualCpcCampaign.setBudget(budget);
    manualCpcCampaign.setBiddingStrategyConfiguration(manualCpcStrategy);
    manualCpcCampaign.setAdServingOptimizationStatus(AdServingOptimizationStatus.CONVERSION_OPTIMIZE);
    manualCpcCampaign.getSettings().add(geoTargetTypeSetting);
    manualCpcCampaign.getSettings().add(targetingSetting);
    manualCpcCampaign.setCampaignType(CampaignType.STANDARD);

    manualCpcCampaign.setTrackingUrl("http://yahoo.co.jp?url={lpurl}&amp;a={creative}&amp;pid={_id1}");
    manualCpcCampaign.setCustomParameters(customParameters);

    // Set App Campaign
    Campaign appCampaign = new Campaign();
    appCampaign.setAccountId(accountId);
    appCampaign.setCampaignName("SampleAppCampaign_CreateOn_" + SoapUtils.getCurrentTimestamp());
    appCampaign.setUserStatus(UserStatus.ACTIVE);
    appCampaign.setStartDate(DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now()));
    appCampaign.setEndDate(DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now().plusMonths(1L)));
    appCampaign.setBudget(budget);
    appCampaign.setBiddingStrategyConfiguration(manualCpcStrategy);
    appCampaign.setAdServingOptimizationStatus(AdServingOptimizationStatus.CONVERSION_OPTIMIZE);
    appCampaign.getSettings().add(geoTargetTypeSetting);
    appCampaign.getSettings().add(targetingSetting);
    appCampaign.setCampaignType(CampaignType.MOBILE_APP);
    appCampaign.setAppStore(AppStore.IOS);
    appCampaign.setAppId(SoapUtils.getCurrentTimestamp());

    operation.getOperand().addAll(Arrays.asList(autoBiddingCampaign, manualCpcCampaign, appCampaign));

    return operation;
  }

  /**
   * create sample request.
   *
   * @param accountId         long
   * @param feedFolderId long
   * @return CampaignOperation
   */
  public static CampaignOperation createSampleDasAddRequest(CampaignOperation operation, long accountId, long feedFolderId) {
    // Set Operation
    if(operation == null) {
      // Add Single Das Campaign
      operation = new CampaignOperation();
      operation.setOperator(Operator.ADD);
      operation.setAccountId(accountId);

    } else if( !operation.getOperator().equals(Operator.ADD) || operation.getAccountId() != accountId) {
      return operation;
    }

    // Set Budget
    Budget budget = new Budget();
    budget.setPeriod(BudgetPeriod.DAILY);
    budget.setAmount((long) 1000);
    budget.setDeliveryMethod(BudgetDeliveryMethod.STANDARD);

    // Set ManualCpc
    CampaignBiddingStrategy manualCpcStrategy = new CampaignBiddingStrategy();
    manualCpcStrategy.setBiddingStrategyType(BiddingStrategyType.MANUAL_CPC);

    // Set DynamicAdsForSearchSetting
    DynamicAdsForSearchSetting dynamicAdsForSearchSetting = new DynamicAdsForSearchSetting();
    dynamicAdsForSearchSetting.setType(SettingType.DYNAMIC_ADS_FOR_SEARCH_SETTING);
    dynamicAdsForSearchSetting.getFeedFolderIds().add(feedFolderId);

    // Set DAS Campaign
    Campaign dasCampaign = new Campaign();
    dasCampaign.setAccountId(accountId);
    dasCampaign.setCampaignName("SampleDasCampaign_CreateOn_" + SoapUtils.getCurrentTimestamp());
    dasCampaign.setUserStatus(UserStatus.ACTIVE);
    dasCampaign.setBudget(budget);
    dasCampaign.setBiddingStrategyConfiguration(manualCpcStrategy);
    dasCampaign.setCampaignType(CampaignType.DYNAMIC_ADS_FOR_SEARCH);
    dasCampaign.getSettings().add(dynamicAdsForSearchSetting);

    operation.getOperand().addAll(Arrays.asList(dasCampaign));

    return operation;
  }

  /**
   * create sample request.
   *
   * @param accountId         long
   * @param biddingStrategyId long
   * @param campaignValues    CampaignValues
   * @return CampaignOperation
   */
  public static CampaignOperation createSampleSetRequest(long accountId, long biddingStrategyId, List<CampaignValues> campaignValues) {
    // Set Operation
    CampaignOperation operation = new CampaignOperation();
    operation.setOperator(Operator.SET);
    operation.setAccountId(accountId);

    // Set Operand
    for (CampaignValues campaignValue : campaignValues) {

      // Set Budget
      Budget budget = new Budget();
      budget.setPeriod(BudgetPeriod.DAILY);
      budget.setAmount((long) 2000);
      budget.setDeliveryMethod(BudgetDeliveryMethod.STANDARD);

      // Set AutoBidding
      CampaignBiddingStrategy autoBiddingStrategy = new CampaignBiddingStrategy();
      autoBiddingStrategy.setBiddingStrategyId(biddingStrategyId);

      Campaign campaign = new Campaign();
      campaign.setAccountId(campaignValue.getCampaign().getAccountId());
      campaign.setCampaignId(campaignValue.getCampaign().getCampaignId());
      campaign.setCampaignName("Sample_UpdateOn_" + campaignValue.getCampaign().getCampaignId() + "_" + SoapUtils.getCurrentTimestamp());
      campaign.setUserStatus(UserStatus.PAUSED);
      campaign.setBudget(budget);
      campaign.setAdServingOptimizationStatus(AdServingOptimizationStatus.OPTIMIZE);

      // Change Auto Bidding Strategy
      campaign.setBiddingStrategyConfiguration(autoBiddingStrategy);

      if (CampaignType.STANDARD.equals(campaign.getCampaignType())) {
        campaign.setTrackingUrl("http://yahoo.co.jp?url={lpurl}&amp;a={creative}&amp;pid={_id2}");
        // Set CustomParameters
        CustomParameters customParameters = new CustomParameters();
        CustomParameter parameter1 = new CustomParameter();
        parameter1.setKey("id2");
        parameter1.setValue("5678");
        customParameters.getParameters().addAll(Arrays.asList(parameter1));
        campaign.setCustomParameters(customParameters);
      }
      operation.getOperand().add(campaign);
    }

    return operation;
  }

  /**
   * create sample request.
   *
   * @param accountId      long
   * @param campaignValues CampaignValues
   * @return CampaignOperation
   */
  public static CampaignOperation createSampleRemoveRequest(long accountId, List<CampaignValues> campaignValues) {
    // Set Operation
    CampaignOperation operation = new CampaignOperation();
    operation.setOperator(Operator.REMOVE);
    operation.setAccountId(accountId);

    // Set Operand
    for (CampaignValues campaignValue : campaignValues) {

      Campaign campaign = new Campaign();
      campaign.setAccountId(campaignValue.getCampaign().getAccountId());
      campaign.setCampaignId(campaignValue.getCampaign().getCampaignId());

      operation.getOperand().add(campaign);
    }

    return operation;
  }

  /**
   * create sample request.
   *
   * @param accountId      long
   * @param campaignValues CampaignValues
   * @return CampaignSelector
   */
  public static CampaignSelector createSampleGetRequest(long accountId, List<CampaignValues> campaignValues) {
    // Set Selector
    CampaignSelector selector = new CampaignSelector();
    selector.setAccountId(accountId);
    for (CampaignValues campaignValue : campaignValues) {
      selector.getCampaignIds().add((campaignValue.getCampaign().getCampaignId()));
    }
    selector.getUserStatuses().addAll(Arrays.asList(UserStatus.ACTIVE, UserStatus.PAUSED));

    // Set Paging
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
  }
}
