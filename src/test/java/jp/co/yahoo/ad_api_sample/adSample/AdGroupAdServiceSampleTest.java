package jp.co.yahoo.ad_api_sample.adSample;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V6.AdGroupAdService.AdGroupAdOperation;
import jp.yahooapis.ss.V6.AdGroupAdService.AdGroupAdSelector;
import jp.yahooapis.ss.V6.AdGroupAdService.AdGroupAdValues;
import jp.yahooapis.ss.V6.AdGroupAdService.Advanced;
import jp.yahooapis.ss.V6.AdGroupAdService.ApprovalStatus;
import jp.yahooapis.ss.V6.AdGroupAdService.Paging;
import jp.yahooapis.ss.V6.AdGroupAdService.UserStatus;

import org.junit.Before;
import org.junit.Test;

/**
 * Sample TestCase for AdGroupAdServiceSampleTest. Copyright (C) 2012 Yahoo Japan Corporation. All
 * Rights Reserved.
 */
public class AdGroupAdServiceSampleTest {

  /**
   * Setting
   */
  private long accountId;
  private long campaignId;
  private long adGroupId;
  private long appCampaignId;
  private long appAdGroupId;

  @Before
  public void setup() {
    accountId = SoapUtils.getAccountId();
    campaignId = SoapUtils.getCampaignId();
    adGroupId = SoapUtils.getAdGroupId();
    appCampaignId = SoapUtils.getAppCampaignId();
    appAdGroupId = SoapUtils.getAppAdGroupId();
  }

  /**
   * Sample TestCase of main method for AdGroupAdServiceSample.
   */
  @Test
  public void testMain() throws Exception {
    // Run
    try {
      AdGroupAdServiceSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }

  /**
   * Sample TestCase of add method for AdGroupAdServiceSample.
   */
  @Test
  public void testAdd() throws Exception {
    // Set Operation
    AdGroupAdOperation addAdGroupAdOperation = AdGroupAdServiceSample.createSampleAddRequest(accountId, campaignId, adGroupId, appCampaignId, appAdGroupId);

    // Run
    List<AdGroupAdValues> addAdGroupAdValues = null;
    try {
      addAdGroupAdValues = AdGroupAdServiceSample.add(addAdGroupAdOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (AdGroupAdValues adGroupAdValues : addAdGroupAdValues) {
      assertThat(adGroupAdValues.isOperationSucceeded(), is(true));
      assertThat(adGroupAdValues.getAdGroupAd().getAccountId(), is(notNullValue()));
    }

    clean(addAdGroupAdValues);
  }

  /**
   * Sample TestCase of set method for AdGroupAdServiceSample.
   */
  @Test
  public void testSet() throws Exception {
    // =================================================================
    // AdGroupAdService ADD
    // =================================================================
    List<AdGroupAdValues> addAdGroupAdValues = null;
    try {
      AdGroupAdOperation addAdGroupAdOperation = AdGroupAdServiceSample.createSampleAddRequest(accountId, campaignId, adGroupId, appCampaignId, appAdGroupId);
      addAdGroupAdValues = AdGroupAdServiceSample.add(addAdGroupAdOperation);
    } catch (Exception e) {
      fail();
    }

    // =================================================================
    // AdGroupAdService SET
    // =================================================================
    // Set Operation
    AdGroupAdOperation setAdGroupAdOperation = AdGroupAdServiceSample.createSampleSetRequest(accountId, addAdGroupAdValues);

    // Run
    List<AdGroupAdValues> setAdGroupAdValues = null;
    try {
      setAdGroupAdValues = AdGroupAdServiceSample.set(setAdGroupAdOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (AdGroupAdValues adGroupAdValues : setAdGroupAdValues) {
      assertThat(adGroupAdValues.isOperationSucceeded(), is(true));
      assertThat(adGroupAdValues.getAdGroupAd().getAccountId(), is(notNullValue()));
    }

    clean(setAdGroupAdValues);
  }

  /**
   * Sample TestCase of remove method for AdGroupAdServiceSample.
   */
  @Test
  public void testRemove() throws Exception {
    // =================================================================
    // AdGroupAdService ADD
    // =================================================================
    List<AdGroupAdValues> addAdGroupAdValues = null;
    try {
      AdGroupAdOperation addAdGroupAdOperation = AdGroupAdServiceSample.createSampleAddRequest(accountId, campaignId, adGroupId, appCampaignId, appAdGroupId);
      addAdGroupAdValues = AdGroupAdServiceSample.add(addAdGroupAdOperation);
    } catch (Exception e) {
      fail();
    }

    // =================================================================
    // AdGroupAdService REMOVE
    // =================================================================
    // Set Operation
    AdGroupAdOperation removeAdGroupAdOperation = AdGroupAdServiceSample.createSampleRemoveRequest(accountId, addAdGroupAdValues);

    // Run
    List<AdGroupAdValues> removeAdGroupAdValues = null;
    try {
      removeAdGroupAdValues = AdGroupAdServiceSample.remove(removeAdGroupAdOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (AdGroupAdValues adGroupAdValues : removeAdGroupAdValues) {
      assertThat(adGroupAdValues.isOperationSucceeded(), is(true));
      assertThat(adGroupAdValues.getAdGroupAd().getAccountId(), is(notNullValue()));
    }
  }

  /**
   * Sample TestCase of get method for AdGroupAdServiceSample.
   */
  @Test
  public void testGet() throws Exception {
    // =================================================================
    // AdGroupAdService ADD
    // =================================================================
    // Set Selector
    AdGroupAdSelector selector = new AdGroupAdSelector();
    selector.setAccountId(accountId);
    selector.getCampaignIds().add(campaignId);
    selector.getAdGroupIds().add(adGroupId);
    selector.getUserStatuses().addAll(Arrays.asList(UserStatus.ACTIVE, UserStatus.PAUSED));
    selector.getApprovalStatuses().addAll(
        Arrays.asList(ApprovalStatus.APPROVED, ApprovalStatus.APPROVED_WITH_REVIEW, ApprovalStatus.REVIEW, ApprovalStatus.POST_DISAPPROVED, ApprovalStatus.PRE_DISAPPROVED));
    selector.setAdvanced(Advanced.TRUE);
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    // Run
    List<AdGroupAdValues> getAdGroupAdValues = null;
    try {
      getAdGroupAdValues = AdGroupAdServiceSample.get(selector);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (AdGroupAdValues adGroupAdValues : getAdGroupAdValues) {
      assertThat(adGroupAdValues.isOperationSucceeded(), is(true));
      assertThat(adGroupAdValues.getAdGroupAd().getAccountId(), is(notNullValue()));
    }
  }

  /**
   * clean
   */
  public void clean(List<AdGroupAdValues> adGroupAdValues) {
    try {
      AdGroupAdOperation removeAdGroupAdOperation = AdGroupAdServiceSample.createSampleRemoveRequest(accountId, adGroupAdValues);
      AdGroupAdServiceSample.remove(removeAdGroupAdOperation);
    } catch (Exception e) {
      fail();
    }
  }
}
