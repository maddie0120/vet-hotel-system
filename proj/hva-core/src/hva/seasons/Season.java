package hva.seasons;

import java.io.Serializable;


public abstract class Season implements Serializable {

   public abstract int getSeasonIndex();
   public abstract int effortE();
   public abstract int effortD();
   public abstract String cycleE();
   public abstract String cycleD();
   public abstract Season nextSeason();

}