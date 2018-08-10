package com.bootcamp.folio_range;

import com.bootcamp.folio_range.components.FolioTransaction;

import java.util.ArrayList;
import java.util.Arrays;
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
    		if (first.getStart() > second.getStart()) {
    			FolioTransaction temp = first;
    			first = second;
    			second = temp;
    		} 
    		
        int start1 = first.getStart();
        int end1 = second.getStart() - 1;
        
        int start2 = second.getStart();
        int end2 = second.getEnd();
        
        FolioTransaction leftSplit = makeNewFolio(start1, end1, first);
        FolioTransaction middleSplit = makeNewFolio(start2, end2, second);
        
        List<FolioTransaction> splits = new ArrayList<>();
        splits.add(leftSplit);
        splits.add(middleSplit);
        
        if (first.getEnd() > second.getEnd()) {
        		int start3 = second.getEnd() + 1;
        		int end3 = first.getEnd();
        		FolioTransaction rightSplit = makeNewFolio(start3, end3, first);
        		splits.add(rightSplit);
        }

        return splits;
    }
    
    public static List<FolioTransaction> combine(FolioTransaction first, FolioTransaction second){
        List<FolioTransaction> list = new  ArrayList<>();
        return list;
    }
    
    private static FolioTransaction makeNewFolio(int start, int end, FolioTransaction fTrans) {
    		return new FolioTransaction(start, end, fTrans.getStatusCode(), fTrans.getTransactionCode());
    }
}
