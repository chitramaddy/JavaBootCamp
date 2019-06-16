package com.company;

public class RewardsMember {

    private String memberId;
    private boolean rewardsMember;

    public RewardsMember(String memberId, boolean rewardsMember) {
        this.memberId = memberId;
        this.rewardsMember = rewardsMember;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public boolean isRewardsMember() {
        return rewardsMember;
    }

    public void setRewardsMember(boolean rewardsMember) {
        this.rewardsMember = rewardsMember;
    }
}
