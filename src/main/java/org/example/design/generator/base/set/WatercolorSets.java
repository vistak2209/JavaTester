package org.example.design.generator.base.set;

import java.util.EnumSet;
import java.util.Set;

import static org.example.design.generator.base.set.Sets.*;
import static org.example.design.generator.base.set.Watercolors.*;
public class WatercolorSets {
    public static void main(String[] args){
        Set<Watercolors> set1 = EnumSet.range(BRILLIANT_RED,VIRIDINA_HUE);
        Set<Watercolors> set2 = EnumSet.range(CERULEAN_BLUE_HUE,ULTRAMARINE);
        Set<Watercolors> subset = intersection(set1,set2);
        System.out.println("subset: "+subset);
        System.out.println("diff: "+difference(set1,subset));
        System.out.println("diff: "+difference(set2,subset));
        System.out.println("complement: "+complement(set1,set2));
    }
}
