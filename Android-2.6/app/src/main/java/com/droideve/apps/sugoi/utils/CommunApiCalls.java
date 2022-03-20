package com.droideve.apps.sugoi.utils;

import android.content.Context;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.droideve.apps.sugoi.AppController;
import com.droideve.apps.sugoi.Services.NotifyDataNotificationEvent;
import com.droideve.apps.sugoi.appconfig.AppContext;
import com.droideve.apps.sugoi.appconfig.Constances;
import com.droideve.apps.sugoi.classes.Module;
import com.droideve.apps.sugoi.classes.Notification;
import com.droideve.apps.sugoi.classes.Setting;
import com.droideve.apps.sugoi.controllers.SettingsController;
import com.droideve.apps.sugoi.controllers.notification.NotificationController;
import com.droideve.apps.sugoi.controllers.sessions.SessionsController;
import com.droideve.apps.sugoi.events.UnseenNotificationEvent;
import com.droideve.apps.sugoi.network.VolleySingleton;
import com.droideve.apps.sugoi.network.api_request.SimpleRequest;
import com.droideve.apps.sugoi.parser.Parser;
import com.droideve.apps.sugoi.parser.api_parser.ModuleParser;
import com.droideve.apps.sugoi.parser.api_parser.NotificationParser;
import com.droideve.apps.sugoi.parser.api_parser.SettingParser;
import com.droideve.apps.sugoi.parser.tags.Tags;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import io.realm.RealmList;

import static com.droideve.apps.sugoi.appconfig.AppConfig.APP_DEBUG;

public class CommunApiCalls {

    public static void getNotifications(final Context context, final int user_id) {

        RequestQueue queue = VolleySingleton.getInstance(context).getRequestQueue();

        SimpleRequest request = new SimpleRequest(Request.Method.POST,
                Constances.API.API_NOTIFICATIONS_GET, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    if (APP_DEBUG) {
                        Log.e("getNotificationResponse", response);
                    }

                    JSONObject jsonObject = new JSONObject(response);
                    // Log.e("response", jsonObject.toString());
                    final NotificationParser mNotificationParser = new NotificationParser(jsonObject);
                    int success = Integer.parseInt(mNotificationParser.getStringAttr(Tags.SUCCESS));

                    if (success == 1 && mNotificationParser.getNotifications(context).size() > 0) {
                        NotificationController.removeAll();
                        NotificationController.insertNotifications(
                                mNotificationParser.getNotifications(context)
                        );


                        //subscrib event listener to update the badge number
                        int countUnseenNotif = NotificationController.countUnseenNotifications();
                        EventBus.getDefault().postSticky(new UnseenNotificationEvent(String.valueOf(countUnseenNotif)));
                    }

                } catch (JSONException e) {
                    //send a rapport to support
                    e.printStackTrace();

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (APP_DEBUG) {
                    Log.e("ERROR", error.toString());
                }
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();

                params.put("auth_type", "user");
                params.put("auth_id", String.valueOf(user_id));
                if (APP_DEBUG) {
                    Log.e("LoginActivity", "  params get notification :" + params.toString());
                }

                return params;
            }

        };

        request.setRetryPolicy(new DefaultRetryPolicy(SimpleRequest.TIME_OUT,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        queue.add(request);

    }

    public static void appSettings() {

        RequestQueue queue = VolleySingleton.getInstance(AppController.getInstance()).getRequestQueue();

        SimpleRequest request = new SimpleRequest(Request.Method.GET,
                Constances.API.API_APP_CONFIG, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    if (AppContext.DEBUG)
                        Log.e("app_config", response);

                    JSONObject js = new JSONObject(response);

                    final SettingParser mSettingParser = new SettingParser(js);
                    int success = Integer.parseInt(mSettingParser.getStringAttr(Tags.SUCCESS));
                    if (success == 1) {
                        RealmList<Setting> appConfigs = mSettingParser.getSettings();
                        if (appConfigs.size() > 0)
                            SettingsController.
                                    updateSettings(appConfigs);
                    }

                } catch (JSONException e) {
                    //send a rapport to support
                    e.printStackTrace();

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (APP_DEBUG) {
                    Log.e("ERROR", error.toString());
                }
            }
        }) {

        };

        request.setRetryPolicy(new DefaultRetryPolicy(SimpleRequest.TIME_OUT,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        queue.add(request);

    }



    public static void getNotificationsCount(final Context context) {

        if (SessionsController.isLogged()) {
            final int user_id = SessionsController.getSession().getUser().getId();
            RequestQueue queue = VolleySingleton.getInstance(context).getRequestQueue();

            SimpleRequest request = new SimpleRequest(Request.Method.POST,
                    Constances.API.API_NOTIFICATIONS_COUNT_GET, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    try {

                        if (APP_DEBUG) {
                            Log.e("getNotificationResponse", response);
                        }

                        JSONObject jsonObject = new JSONObject(response);
                        // Log.e("response", jsonObject.toString());
                        final Parser mNotificationParser = new Parser(jsonObject);

                        if (mNotificationParser.getSuccess() == 1) {

                            //subscrib event listener to update the badge number
                            int countUnseenNotif = Integer.parseInt(mNotificationParser.getStringAttr(Tags.RESULT));
                            EventBus.getDefault().postSticky(new UnseenNotificationEvent(String.valueOf(countUnseenNotif)));
                        }

                    } catch (JSONException e) {
                        //send a rapport to support
                        e.printStackTrace();

                    }


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if (APP_DEBUG) {
                        Log.e("ERROR", error.toString());
                    }
                }
            }) {

                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<String, String>();

                    params.put("auth_type", "user");
                    params.put("auth_id", String.valueOf(user_id));
                    if (APP_DEBUG) {
                        Log.e("UnseenNotifCount", "  params get notification :" + params.toString());
                    }

                    return params;
                }

            };

            request.setRetryPolicy(new DefaultRetryPolicy(SimpleRequest.TIME_OUT,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

            queue.add(request);
        }

    }


    public static void countUnseenNotifications(final Context context) {


        Map<String, String> params = new HashMap<String, String>();

        if (SessionsController.getLocalDatabase.isLogged()) {
            params.put("user_id", String.valueOf(SessionsController.getLocalDatabase.getUserId()));
            params.put("guest_id", String.valueOf(SessionsController.getLocalDatabase.getGuestId()));
        } else {
            params.put("auth_type", "guest");
            params.put("auth_id", String.valueOf(SessionsController.getLocalDatabase.getGuestId()));
        }

        params.put("status", "0");

        RequestQueue queue = VolleySingleton.getInstance(context).getRequestQueue();

        SimpleRequest request = new SimpleRequest(Request.Method.POST,
                Constances.API.API_NOTIFICATIONS_COUNT_GET, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    if (APP_DEBUG) {
                        Log.e("getNotificationResponse", response);
                    }

                    JSONObject jsonObject = new JSONObject(response);
                    // Log.e("response", jsonObject.toString());
                    final Parser mNotificationParser = new Parser(jsonObject);

                    if (mNotificationParser.getSuccess() == 1) {

                        //subscrib esvent listener to update the badge number
                        int countUnseenNotif = Integer.parseInt(mNotificationParser.getStringAttr(Tags.RESULT));

                        if (APP_DEBUG)
                            Log.e("NotificationsCount", "unseen notification " + countUnseenNotif);

                        Notification.notificationsUnseen = countUnseenNotif;

                        //update ui
                        EventBus.getDefault().post(new NotifyDataNotificationEvent("update_badges"));
                    }

                } catch (JSONException e) {
                    //send a rapport to support
                    e.printStackTrace();

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (APP_DEBUG) {
                    Log.e("ERROR", error.toString());
                }
            }
        }) {

            @Override
            protected Map<String, String> getParams() {

                if (APP_DEBUG) {
                    Log.e("UnseenNotifCount", "  params get notification :" + params.toString());
                }

                return params;
            }

        };

        request.setRetryPolicy(new DefaultRetryPolicy(SimpleRequest.TIME_OUT,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        queue.add(request);

    }


    public static void availableModulesAPI(Context context) {

        RequestQueue queue = VolleySingleton.getInstance(context).getRequestQueue();

        SimpleRequest request = new SimpleRequest(Request.Method.GET,
                Constances.API.API_AVAILABLE_MODULES, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    if (AppContext.DEBUG)
                        Log.e("modules_manager", response);

                    JSONObject js = new JSONObject(response);

                    // Log.e("response", jsonObject.toString());
                    final ModuleParser mModuleParser = new ModuleParser(js);
                    int success = Integer.parseInt(mModuleParser.getStringAttr(Tags.SUCCESS));
                    if (success == 1) {
                        RealmList<Module> listModules = mModuleParser.getModules();
                        if (listModules.size() > 0)
                            SettingsController.updateModules(listModules);
                    }

                } catch (JSONException e) {
                    //send a rapport to support
                    e.printStackTrace();

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (APP_DEBUG) {
                    Log.e("ERROR", error.toString());
                }
            }
        }) {

        };

        request.setRetryPolicy(new DefaultRetryPolicy(SimpleRequest.TIME_OUT,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        queue.add(request);

    }

}
