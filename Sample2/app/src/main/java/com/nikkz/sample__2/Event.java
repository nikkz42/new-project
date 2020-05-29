package com.nikkz.sample__2;

public class Event {
        /** Title of the earthquake event */
        public final String mConfirmed;

        /** Number of people who felt the earthquake and reported how strong it was */
        public final String mRecovered;

        /** Perceived strength of the earthquake from the people's responses */
        public final String mDeaths;

        public final String mActive;

        /**
         * Constructs a new {@link Event}.
         *
         //* @param eventTitle is the title of the earthquake event

         //* @param eventPerceivedStrength is the perceived strength of the earthquake from the responses
         */
        public Event(String confirmed, String recovered, String deaths,String active) {
         mConfirmed=confirmed;
         mRecovered=recovered;
         mDeaths=deaths;
         mActive=active;
        }


    }


