package com.nitjsr.recommendation;

import java.util.*;


/**
 * Write a description of MovieRunnerSimilarRatings here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MovieRunnerSimilarRatings {

    public void printAverageRatingsByAllFilters(String selecGenre, String minMinutes, String maxMinutes, String dirs, String yearAfter){
        int minimalRaters =25;
        String moviefile = "ratedmoviesfull.csv";
        String ratingsfile = "ratings.csv";

        FinalRatings fr = new FinalRatings();
        RaterDatabase.initialize(ratingsfile);
        MovieDatabase.initialize(moviefile);

        System.out.println("Number of raters: "+ RaterDatabase.size());
        System.out.println("read data for "+ MovieDatabase.size() + " movies");

        AllFilters filtersList = new AllFilters();
        if(!selecGenre.isEmpty()) {
            Filter gr = new GenreFilter(selecGenre);
            filtersList.addFilter(gr);
        }

        if(!minMinutes.isEmpty() || !maxMinutes.isEmpty()) {
            try {
                int minM = Integer.parseInt(minMinutes);
                System.out.println("1");
                int maxM = Integer.parseInt(maxMinutes);
                System.out.println("2");
                Filter mr = new MinutesFilter(minM, maxM);
                System.out.println(3);
                filtersList.addFilter(mr);
                System.out.println("4");

            } catch (Exception e) {
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println(e);
                System.out.println("------------------------------------------------------------------------------------");

            }
        }

        if(!dirs.isEmpty()) {
            Filter dr = new DirectorsFilter(dirs);
            filtersList.addFilter(dr);
        }

        if(!yearAfter.isEmpty()) {
            try {
                int yrAfter = Integer.parseInt(yearAfter);
                Filter yr = new YearAfterFilter(yrAfter);
                filtersList.addFilter(yr);

            } catch (Exception e) {
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println(e);
                System.out.println("------------------------------------------------------------------------------------");
            }
        }


        ArrayList<Rating> list = fr.getAverageRatingsByFilter(minimalRaters,filtersList);
        Collections.sort(list);
        System.out.println(list.size() + " movie " + "matched");

        for(Rating r:list){
            String Title = MovieDatabase.getTitle(r.getItem());
            String Genre = MovieDatabase.getGenres(r.getItem());
            String Minutes = String.valueOf(MovieDatabase.getMinutes(r.getItem()));
            String Director = MovieDatabase.getDirector(r.getItem());
            String Year = String.valueOf(MovieDatabase.getYear(r.getItem()));;

            System.out.println(r.getValue()+ " " + Year +" "+ Title + " " + Genre + " " + Director + " " + Minutes);
            System.out.println("       "+ Genre);
        }

    }

    @SuppressWarnings("Duplicates")
    public ArrayList<Rating> printSimiliarRatingsByAllFilters(double[] rates, String selecGenre, String minMinutes, String maxMinutes, String dirs, String yearAfter ){
        int minimalRaters =3;
        String id = "65";
        int numSimilarRaters=15;

        String moviefile = "ratedmoviesfull.csv";
        String ratingsfile = "ratings.csv";
        FinalRatings fr = new FinalRatings();
        RaterDatabase.initialize(ratingsfile);
        MovieDatabase.initialize(moviefile);
        
        RaterDatabase.addRaterRating("1049", "3390572", rates[0]);
        RaterDatabase.addRaterRating("1049", "1201607", rates[1]);
        RaterDatabase.addRaterRating("1049", "1723121", rates[2]);
        RaterDatabase.addRaterRating("1049", "1343092", rates[3]);
        RaterDatabase.addRaterRating("1049", "1951261", rates[4]);
        RaterDatabase.addRaterRating("1049", "3678782", rates[5]);
        RaterDatabase.addRaterRating("1049", "2184339", rates[6]);
        RaterDatabase.addRaterRating("1049", "1454468", rates[7]);
        RaterDatabase.addRaterRating("1049", "2278388", rates[8]);
        RaterDatabase.addRaterRating("1049", "2752200", rates[9]);


        AllFilters filtersList = new AllFilters();
        if(!selecGenre.isEmpty()) {
            Filter gr = new GenreFilter(selecGenre);
            filtersList.addFilter(gr);
        }

        if(!minMinutes.isEmpty() || !maxMinutes.isEmpty()) {
            try {
                int minM = Integer.parseInt(minMinutes);
                System.out.println("1");
                int maxM = Integer.parseInt(maxMinutes);
                System.out.println("2");
                Filter mr = new MinutesFilter(minM, maxM);
                System.out.println(3);
                filtersList.addFilter(mr);
                System.out.println("4");

            } catch (Exception e) {
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println(e);
                System.out.println("------------------------------------------------------------------------------------");

            }
        }

        if(!dirs.isEmpty()) {
            Filter dr = new DirectorsFilter(dirs);
            filtersList.addFilter(dr);
        }

        if(!yearAfter.isEmpty()) {
            try {
                int yrAfter = Integer.parseInt(yearAfter);
                Filter yr = new YearAfterFilter(yrAfter);
                filtersList.addFilter(yr);

            } catch (Exception e) {
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println(e);
                System.out.println("------------------------------------------------------------------------------------");
            }
        }


        ArrayList<Rating> recommendations = fr.getSimilarRatingsByFilter("1049",numSimilarRaters,minimalRaters,filtersList);
        System.out.println(recommendations.size() + " movie " + "matched");

        for(Rating rating:recommendations){
            String movieTitle = MovieDatabase.getTitle((rating.getItem()));
            System.out.println(movieTitle+ " : " + rating.getValue());
        }
        return recommendations;
    }

}