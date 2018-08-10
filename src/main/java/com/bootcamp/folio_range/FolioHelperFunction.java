package com.bootcamp.folio_range;

import com.bootcamp.folio_range.components.FolioTransaction;

import java.util.ArrayList;
import java.util.List;

public class FolioHelperFunction {

    public static void interChange(FolioTransaction first, FolioTransaction second)
    {
        FolioTransaction temp = first;
        first = second;
        second = temp;
    }
    public static boolean splitCondition(FolioTransaction first, FolioTransaction second){
        if((first.getStatusCode()!= second.getStatusCode() || first.getTransactionCode() != second.getTransactionCode()) && (second.getStart() > first.getStart() && second.getStart() < first.getEnd()))
            return true;
        else
            return false;
    }
    public static boolean checkForSplit(FolioTransaction first, FolioTransaction second){
        if(first.getStart() > second.getStart()) {
            interChange(first, second);
        }
        if(splitCondition(first,second)){
                return true;
        }
        return false;
    }

    public static boolean checkForCombine(FolioTransaction first, FolioTransaction second){
        if(first.getStatusCode() == second.getStatusCode() && first.getTransactionCode()== second.getTransactionCode()) {
            if(first.getStart() > second.getStart()) {
                interChange(first, second);
            }
            return (first.getEnd() == (second.getStart())-1);
        }
        return false;
    }
    public static List<FolioTransaction> split(FolioTransaction first, FolioTransaction second){
        List<FolioTransaction> list = new  ArrayList<FolioTransaction>();

        return list;
    }
    public static List<FolioTransaction> combine(FolioTransaction first, FolioTransaction second){
        List<FolioTransaction> list = new  ArrayList<FolioTransaction>();
        return list;
    }
}
