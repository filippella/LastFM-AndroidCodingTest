package fm.last.test.app;

/**
 * @author Filippo
 * @version 1.0.0
 * @since 18/12/2018
 */
public final class TestMockDataProvider {

    public static String getMockAlbumResponse() {
        return "{  \n" +
                "   \"results\":{  \n" +
                "      \"opensearch:Query\":{  \n" +
                "         \"#text\":\"\",\n" +
                "         \"role\":\"request\",\n" +
                "         \"searchTerms\":\"believe\",\n" +
                "         \"startPage\":\"1\"\n" +
                "      },\n" +
                "      \"opensearch:totalResults\":\"114971\",\n" +
                "      \"opensearch:startIndex\":\"0\",\n" +
                "      \"opensearch:itemsPerPage\":\"50\",\n" +
                "      \"albummatches\":{  \n" +
                "         \"album\":[  \n" +
                "            {  \n" +
                "               \"name\":\"Believe\",\n" +
                "               \"artist\":\"Disturbed\",\n" +
                "               \"url\":\"https://www.last.fm/music/Disturbed/Believe\",\n" +
                "               \"image\":[  \n" +
                "                  {  \n" +
                "                     \"#text\":\"https://lastfm-img2.akamaized.net/i/u/34s/bca3b80481394e25b03f4fc77c338897.png\",\n" +
                "                     \"size\":\"small\"\n" +
                "                  },\n" +
                "                  {  \n" +
                "                     \"#text\":\"https://lastfm-img2.akamaized.net/i/u/64s/bca3b80481394e25b03f4fc77c338897.png\",\n" +
                "                     \"size\":\"medium\"\n" +
                "                  },\n" +
                "                  {  \n" +
                "                     \"#text\":\"https://lastfm-img2.akamaized.net/i/u/174s/bca3b80481394e25b03f4fc77c338897.png\",\n" +
                "                     \"size\":\"large\"\n" +
                "                  },\n" +
                "                  {  \n" +
                "                     \"#text\":\"https://lastfm-img2.akamaized.net/i/u/300x300/bca3b80481394e25b03f4fc77c338897.png\",\n" +
                "                     \"size\":\"extralarge\"\n" +
                "                  }\n" +
                "               ],\n" +
                "               \"streamable\":\"0\",\n" +
                "               \"mbid\":\"c559efc2-f734-41ae-93bd-2d78414e0356\"\n" +
                "            }\n" +
                "         ]\n" +
                "      },\n" +
                "      \"@attr\":{  \n" +
                "         \"for\":\"believe\"\n" +
                "      }\n" +
                "   }\n" +
                "}";
    }

    public static String getMockArtistResponse() {
        return "{  \n" +
                "   \"results\":{  \n" +
                "      \"opensearch:Query\":{  \n" +
                "         \"#text\":\"\",\n" +
                "         \"role\":\"request\",\n" +
                "         \"searchTerms\":\"cher\",\n" +
                "         \"startPage\":\"1\"\n" +
                "      },\n" +
                "      \"opensearch:totalResults\":\"60456\",\n" +
                "      \"opensearch:startIndex\":\"0\",\n" +
                "      \"opensearch:itemsPerPage\":\"30\",\n" +
                "      \"artistmatches\":{  \n" +
                "         \"artist\":[  \n" +
                "            {  \n" +
                "               \"name\":\"Cher\",\n" +
                "               \"listeners\":\"1090976\",\n" +
                "               \"mbid\":\"bfcc6d75-a6a5-4bc6-8282-47aec8531818\",\n" +
                "               \"url\":\"https://www.last.fm/music/Cher\",\n" +
                "               \"streamable\":\"0\",\n" +
                "               \"image\":[  \n" +
                "                  {  \n" +
                "                     \"#text\":\"https://lastfm-img2.akamaized.net/i/u/34s/879a88760860cc472d826ca4e7fc5ad6.png\",\n" +
                "                     \"size\":\"small\"\n" +
                "                  },\n" +
                "                  {  \n" +
                "                     \"#text\":\"https://lastfm-img2.akamaized.net/i/u/64s/879a88760860cc472d826ca4e7fc5ad6.png\",\n" +
                "                     \"size\":\"medium\"\n" +
                "                  },\n" +
                "                  {  \n" +
                "                     \"#text\":\"https://lastfm-img2.akamaized.net/i/u/174s/879a88760860cc472d826ca4e7fc5ad6.png\",\n" +
                "                     \"size\":\"large\"\n" +
                "                  },\n" +
                "                  {  \n" +
                "                     \"#text\":\"https://lastfm-img2.akamaized.net/i/u/300x300/879a88760860cc472d826ca4e7fc5ad6.png\",\n" +
                "                     \"size\":\"extralarge\"\n" +
                "                  },\n" +
                "                  {  \n" +
                "                     \"#text\":\"https://lastfm-img2.akamaized.net/i/u/300x300/879a88760860cc472d826ca4e7fc5ad6.png\",\n" +
                "                     \"size\":\"mega\"\n" +
                "                  }\n" +
                "               ]\n" +
                "            }\n" +
                "         ]\n" +
                "      },\n" +
                "      \"@attr\":{  \n" +
                "         \"for\":\"cher\"\n" +
                "      }\n" +
                "   }\n" +
                "}";
    }

    public static String getMockTrackResponse() {
        return "{  \n" +
                "   \"results\":{  \n" +
                "      \"opensearch:Query\":{  \n" +
                "         \"#text\":\"\",\n" +
                "         \"role\":\"request\",\n" +
                "         \"startPage\":\"1\"\n" +
                "      },\n" +
                "      \"opensearch:totalResults\":\"655236\",\n" +
                "      \"opensearch:startIndex\":\"0\",\n" +
                "      \"opensearch:itemsPerPage\":\"30\",\n" +
                "      \"trackmatches\":{  \n" +
                "         \"track\":[  \n" +
                "            {  \n" +
                "               \"name\":\"Believer\",\n" +
                "               \"artist\":\"Imagine Dragons\",\n" +
                "               \"url\":\"https://www.last.fm/music/Imagine+Dragons/_/Believer\",\n" +
                "               \"streamable\":\"FIXME\",\n" +
                "               \"listeners\":\"269483\",\n" +
                "               \"image\":[  \n" +
                "                  {  \n" +
                "                     \"#text\":\"https://lastfm-img2.akamaized.net/i/u/34s/d645cfa73e13eb828349968ec2d0e234.png\",\n" +
                "                     \"size\":\"small\"\n" +
                "                  },\n" +
                "                  {  \n" +
                "                     \"#text\":\"https://lastfm-img2.akamaized.net/i/u/64s/d645cfa73e13eb828349968ec2d0e234.png\",\n" +
                "                     \"size\":\"medium\"\n" +
                "                  },\n" +
                "                  {  \n" +
                "                     \"#text\":\"https://lastfm-img2.akamaized.net/i/u/174s/d645cfa73e13eb828349968ec2d0e234.png\",\n" +
                "                     \"size\":\"large\"\n" +
                "                  },\n" +
                "                  {  \n" +
                "                     \"#text\":\"https://lastfm-img2.akamaized.net/i/u/300x300/d645cfa73e13eb828349968ec2d0e234.png\",\n" +
                "                     \"size\":\"extralarge\"\n" +
                "                  }\n" +
                "               ],\n" +
                "               \"mbid\":\"\"\n" +
                "            }\n" +
                "         ]\n" +
                "      },\n" +
                "      \"@attr\":{  \n" +
                "\n" +
                "      }\n" +
                "   }\n" +
                "}\n";
    }
}
