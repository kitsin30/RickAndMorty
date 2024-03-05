package com.sin.rickandmorty.response;

import com.google.gson.annotations.SerializedName;

public class PageInfoResponse {

    @SerializedName("count")
    private int count;
    @SerializedName("pages")
    private int page;
    @SerializedName("next")
    private String next;
    @SerializedName("prev")
    private String prev;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }
}
