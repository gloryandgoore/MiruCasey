package com.example.mirucasey.service;

public class NetworkingService {

    public static void main(String[] args){

//        Response response = client.newCall(request).execute();
    }
//    public interface NetworkingListener{
//        void gettingJsonIsCompleted(String json);
//    }
    
//    public NetworkingListener listener;
//    Handler handler = new Handler(Looper.getMainLooper());
    
//    String animeURL1 = "https://anime-db.p.rapidapi.com/anime?page=1&size=10&search=" ;
//    String animeURL2 =  "&sortBy=ranking&sortOrder=asc";
//    String animeURL3 = "https://anime-db.p.rapidapi.com/anime/by-id/";

//    public void getAllAnimes(String query){
//        String fullString = animeURL1 + query + animeURL2;
//        connect(fullString);
//    }

//    public void getDetailsOfSelectedAnime(Anime selectedAnime){
//        String fullString = animeURL3 + selectedAnime.getId();
//        connect(fullString);
//
//    }

//    public void getHeaderAnime(Anime selectedAnime) throws IOException {
//        OkHttpClient client = new OkHttpClient();
//
//        Request request = new Request.Builder()
//                .url("https://anime-db.p.rapidapi.com/anime?page=1&size=10&genres=Award%20Winning&sortBy=ranking&sortOrder=asc")
//                .get()
//                .addHeader("X-RapidAPI-Key", "c6d174dc42msh926955b2f690e00p1e37fdjsn6b6fedb2172d")
//                .addHeader("X-RapidAPI-Host", "anime-db.p.rapidapi.com")
//                .build();
//
//        Response response = client.newCall(request).execute();
//
//    }


//    void connect(String urlString){
//        MyApp.executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//                HttpURLConnection urlConnection = null;
//                try {
//                    int value = 0;
//                    URL url = new URL(urlString);
//                    urlConnection = (HttpURLConnection) url.openConnection();
//                    InputStream in = new BufferedInputStream(urlConnection.getInputStream());
//                    StringBuffer buffer = new StringBuffer();
//                    while((value = in.read()) != -1){
//                        buffer.append((char)value);
//                    }
//                    // the json content is ready to returned back
//                    handler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            listener.gettingJsonIsCompleted(buffer.toString());
//                        }
//                    });
//                } catch (MalformedURLException e) {
//                    e.printStackTrace();
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                finally {
//                    urlConnection.disconnect();
//                }
//
//            }
//        });
//    }
}





//    void gettingImage(String icon) {
//        MyApp.executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    int value = 0;
//                    URL url = new URL(iconURL1 + icon + iconURL2);
//                    //HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//                    InputStream in = url.openStream();//new BufferedInputStream(urlConnection.getInputStream());
//                    Bitmap imageData = BitmapFactory.decodeStream(in);
//
//                    handler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            listener.gettingImageIsCompleted(imageData);
//                        }
//                    });
//                } catch (MalformedURLException e) {
//                    e.printStackTrace();
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//
//            }
//        });
//    }




//public class NetworkingService {
//    public interface NetworkingListener {
//        void gettingJsonIsCompleted(String json);
//    }
//
//    final String TAG = "API";
//    public NetworkingListener listener;
//    Handler handler = new Handler(Looper.getMainLooper());
//    String searchInput = "";
//
//    public void getAllAnimes(String query) {
//        query = searchInput;
//        connect(query);
//    }
////    void getAllGenres(String query){
////        query = searchInput;
////        connect(query);
////    }
//
//    void connect(String urlString) {
//        MyApp.executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//                //Here will be your code
//                OkHttpClient client = new OkHttpClient();
////              OkHttpClient client = new OkHttpClient();
////               Moshi moshi = new Moshi.Builder().build();
////              JsonAdapter<Gist> gistJsonAdapter = moshi.adapter(Gist.class);
//
//                HttpUrl animeSearchUrl = HttpUrl.parse("https://anime-db.p.rapidapi.com/anime").newBuilder()
//                        .addQueryParameter("page", "2")
//                        .addQueryParameter("size", "10")
//                        .addQueryParameter("search", searchInput)
//                        .addQueryParameter("sortBy", "ranking")
//                        .addQueryParameter("sortOrder", "asc")
//                        .build();
//
//                Request request = new Request.Builder()
//                        .url(animeSearchUrl)
//                        .get()
//                        .addHeader("X-RapidAPI-Key", "c6d174dc42msh926955b2f690e00p1e37fdjsn6b6fedb2172d")
//                        .addHeader("X-RapidAPI-Host", "anime-db.p.rapidapi.com")
//                        .build();
//
////        Response response = client.newCall(request).execute();
////                    InputStream is = response.body().byteStream();
//
//                client.newCall(request).enqueue(new Callback() {
//                    @Override
//                    public void onFailure(@NonNull Call call, @NonNull IOException e) {
//                        e.printStackTrace();
//                    }
//
//                    @Override
//                    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
//
//                        if (response.isSuccessful()) {
//                            ResponseBody responseBody = response.body();
//                            String body = responseBody.string();
//                            Log.d(TAG, "onResponse: " + responseBody.string());
//                        } else {
//                            ResponseBody responseBody = response.body();
//                            String body = responseBody.string();
//                            Log.d(TAG, "onResponse: " + responseBody.string());
//                        }
//
//                    }
//                });
//
//            }
//        });
//
//    }
//}
