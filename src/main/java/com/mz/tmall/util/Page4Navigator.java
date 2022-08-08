package com.mz.tmall.util;

import org.springframework.data.domain.Page;

import java.util.List;

public class Page4Navigator<T> {
    Page<T> pageFromJPA;
    int navigatePages; // # of pages navigatable
    int totalPages; // total # of pages
    int number; // current page number
    long totalElements; // total # of elements
    int size; // # of elements on one page
    int numberOfElements; // # of elements on the current page
    List<T> content; // list of the elements
    boolean hasContent;
    boolean first;
    boolean last;
    boolean hasNext;
    boolean hasPrevious;
    int[] navigatePageNums; // page nums to navigate from; TODO: compare with deque

    public int getNavigatePages() {
        return navigatePages;
    }

    public void setNavigatePages(int navigatePages) {
        this.navigatePages = navigatePages;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public boolean isHasContent() {
        return hasContent;
    }

    public void setHasContent(boolean hasContent) {
        this.hasContent = hasContent;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public boolean isHasPrevious() {
        return hasPrevious;
    }

    public void setHasPrevious(boolean hasPrevious) {
        this.hasPrevious = hasPrevious;
    }

    public int[] getNavigatePageNums() {
        return navigatePageNums;
    }

    public void setNavigatePageNums(int[] navigatePageNums) {
        this.navigatePageNums = navigatePageNums;
    }

    public Page<T> getPageFromJPA() {
        return pageFromJPA;
    }

    public void setPageFromJPA(Page<T> pageFromJPA) {
        this.pageFromJPA = pageFromJPA;
    }



    public Page4Navigator(){

    }

    public Page4Navigator(Page<T> Page, int numOfPages){
        this.pageFromJPA = Page;
        this.navigatePages = numOfPages;

        totalPages = pageFromJPA.getTotalPages();
        number = pageFromJPA.getNumber();
        totalElements = pageFromJPA.getTotalElements();
        size = pageFromJPA.getSize();
        numberOfElements = pageFromJPA.getNumberOfElements();
        content = pageFromJPA.getContent();
        hasContent = pageFromJPA.hasContent();
        first = pageFromJPA.isFirst();
        last = pageFromJPA.isLast();
        hasNext = pageFromJPA.hasNext();
        hasPrevious = pageFromJPA.hasPrevious();
        calcNavigatePageNums();
    }

    private void calcNavigatePageNums(){
        int navigatePageNums[];
        int totalPages = getTotalPages();
        int number = getNumber();
        if(totalPages <= navigatePages){
            navigatePageNums = new int[totalPages];
            for(int i=0; i<totalPages; i++){
                navigatePageNums[i] = i+1;
            }
        } else {
            navigatePageNums = new int[navigatePages];
            int startNum = number - navigatePages / 2;
            int endNum = number + navigatePages / 2;

            if(startNum < 1){
                startNum = 1;
                for(int i=0; i<navigatePages; i++){
                    navigatePageNums[i] = startNum++;
                }
            } else if(endNum > totalPages){
                endNum = totalPages;
                for(int i=navigatePages - 1; i>= 0; i--){
                    navigatePageNums[i] = endNum--;
                }
            } else {
                for(int i=0; i<navigatePages; i++){
                    navigatePageNums[i] = startNum++;
                }
            }
        }
        this.navigatePageNums = navigatePageNums;
    }
}
