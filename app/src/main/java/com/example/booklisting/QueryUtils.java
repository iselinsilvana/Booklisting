package com.example.booklisting;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class QueryUtils {

    //String containing hardcoded json data
    //Will be replaced later
    private static final String SAMPLE_JSON_RESPONSE ="{\n" +
            " \"kind\": \"books#volumes\",\n" +
            " \"totalItems\": 435,\n" +
            " \"items\": [\n" +
            "  {\n" +
            "   \"kind\": \"books#volume\",\n" +
            "   \"id\": \"qKFDDAAAQBAJ\",\n" +
            "   \"etag\": \"mHE92WWpjpo\",\n" +
            "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/qKFDDAAAQBAJ\",\n" +
            "   \"volumeInfo\": {\n" +
            "    \"title\": \"Android\",\n" +
            "    \"authors\": [\n" +
            "     \"P.K. Dixit\"\n" +
            "    ],\n" +
            "    \"publisher\": \"Vikas Publishing House\",\n" +
            "    \"publishedDate\": \"2014\",\n" +
            "    \"description\": \"Android is a movement that has transferred data from laptop to hand-held devices like mobiles. Though there are alternate technologies that compete with Android, but it is the front runner in mobile technology by a long distance. Good knowledge in basic Java will help you to understand and develop Android technology and apps. Many universities in India and across the world are now teaching Android in their syllabus, which shows the importance of this subject. This book can be read by anyone who knows Java and XML concepts. It includes a lot of diagrams along with explanations to facilitate better understanding by students. This book aptly concludes with a project that uses Android, which will greatly benefit students in learning the practical aspects of Android. Key Features • Instructions in designing different Android user interfaces • Thorough explanations of all activities • JSON • Android-based project to aid practical understanding\",\n" +
            "    \"industryIdentifiers\": [\n" +
            "     {\n" +
            "      \"type\": \"ISBN_13\",\n" +
            "      \"identifier\": \"9789325977884\"\n" +
            "     },\n" +
            "     {\n" +
            "      \"type\": \"ISBN_10\",\n" +
            "      \"identifier\": \"9325977885\"\n" +
            "     }\n" +
            "    ],\n" +
            "    \"readingModes\": {\n" +
            "     \"text\": false,\n" +
            "     \"image\": true\n" +
            "    },\n" +
            "    \"pageCount\": 372,\n" +
            "    \"printType\": \"BOOK\",\n" +
            "    \"categories\": [\n" +
            "     \"Computers\"\n" +
            "    ],\n" +
            "    \"maturityRating\": \"NOT_MATURE\",\n" +
            "    \"allowAnonLogging\": false,\n" +
            "    \"contentVersion\": \"preview-1.0.0\",\n" +
            "    \"panelizationSummary\": {\n" +
            "     \"containsEpubBubbles\": false,\n" +
            "     \"containsImageBubbles\": false\n" +
            "    },\n" +
            "    \"imageLinks\": {\n" +
            "     \"smallThumbnail\": \"http://books.google.com/books/content?id=qKFDDAAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "     \"thumbnail\": \"http://books.google.com/books/content?id=qKFDDAAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "    },\n" +
            "    \"language\": \"en\",\n" +
            "    \"previewLink\": \"http://books.google.no/books?id=qKFDDAAAQBAJ&printsec=frontcover&dq=android&hl=&cd=1&source=gbs_api\",\n" +
            "    \"infoLink\": \"https://play.google.com/store/books/details?id=qKFDDAAAQBAJ&source=gbs_api\",\n" +
            "    \"canonicalVolumeLink\": \"https://market.android.com/details?id=book-qKFDDAAAQBAJ\"\n" +
            "   },\n" +
            "   \"saleInfo\": {\n" +
            "    \"country\": \"NO\",\n" +
            "    \"saleability\": \"FOR_SALE\",\n" +
            "    \"isEbook\": true,\n" +
            "    \"listPrice\": {\n" +
            "     \"amount\": 155.51,\n" +
            "     \"currencyCode\": \"NOK\"\n" +
            "    },\n" +
            "    \"retailPrice\": {\n" +
            "     \"amount\": 136.07,\n" +
            "     \"currencyCode\": \"NOK\"\n" +
            "    },\n" +
            "    \"buyLink\": \"https://play.google.com/store/books/details?id=qKFDDAAAQBAJ&rdid=book-qKFDDAAAQBAJ&rdot=1&source=gbs_api\",\n" +
            "    \"offers\": [\n" +
            "     {\n" +
            "      \"finskyOfferType\": 1,\n" +
            "      \"listPrice\": {\n" +
            "       \"amountInMicros\": 1.5551E8,\n" +
            "       \"currencyCode\": \"NOK\"\n" +
            "      },\n" +
            "      \"retailPrice\": {\n" +
            "       \"amountInMicros\": 1.3607E8,\n" +
            "       \"currencyCode\": \"NOK\"\n" +
            "      }\n" +
            "     }\n" +
            "    ]\n" +
            "   },\n" +
            "   \"accessInfo\": {\n" +
            "    \"country\": \"NO\",\n" +
            "    \"viewability\": \"PARTIAL\",\n" +
            "    \"embeddable\": true,\n" +
            "    \"publicDomain\": false,\n" +
            "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "    \"epub\": {\n" +
            "     \"isAvailable\": false\n" +
            "    },\n" +
            "    \"pdf\": {\n" +
            "     \"isAvailable\": true,\n" +
            "     \"acsTokenLink\": \"http://books.google.no/books/download/Android-sample-pdf.acsm?id=qKFDDAAAQBAJ&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "    },\n" +
            "    \"webReaderLink\": \"http://play.google.com/books/reader?id=qKFDDAAAQBAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "    \"accessViewStatus\": \"SAMPLE\",\n" +
            "    \"quoteSharingAllowed\": false\n" +
            "   },\n" +
            "   \"searchInfo\": {\n" +
            "    \"textSnippet\": \"Many universities in India and across the world are now teaching Android in their syllabus, which shows the importance of this subject. This book can be read by anyone who knows Java and XML concepts.\"\n" +
            "   }\n" +
            "  }\n" +
            " ]\n" +
            "}";

    private static final String LOG_TAG = QueryUtils.class.getSimpleName();

    private QueryUtils() {
    }

    public static ArrayList<Book> extractBooks() {
        ArrayList<Book> books = new ArrayList<>();

        try {
            JSONObject baseResponse = new JSONObject(SAMPLE_JSON_RESPONSE);
            JSONArray bookArray = baseResponse.getJSONArray("items");
            for (int i = 0; i < bookArray.length(); i++) {
                JSONObject currentBook = bookArray.getJSONObject(i);
                JSONObject bookInfo = currentBook.getJSONObject("volumeInfo");
                String bookTitle = bookInfo.getString("title");
                JSONArray jsonAuthors = bookInfo.getJSONArray("authors");
                String bookAuthors = "";
                for (int j =0; j < jsonAuthors.length()-1; j++){
                    bookAuthors += jsonAuthors.getString(j) + ", ";
                }
                bookAuthors += jsonAuthors.getString(jsonAuthors.length()-1);
                Book book = new Book(bookTitle,bookAuthors);
                books.add(book);

            }

        }
        catch (JSONException e) {
            Log.e(LOG_TAG, "Error: Problem parsing the JSON result", e);

        }
        return books;
    }
}
