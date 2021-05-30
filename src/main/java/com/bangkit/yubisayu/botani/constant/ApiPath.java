package com.bangkit.yubisayu.botani.constant;

public class ApiPath {

    public static final String API_PATH = "/api";

    /**
     * Image API Path
     */
    public static final String UPLOAD_IMAGE_FILE_PATH = API_PATH + "/upload/{filePath}";

    /**
     * User API Path
     */
    public static final String USER = API_PATH + "/user";
    public static final String USERS = API_PATH + "/users";
    public static final String USERS_ID = USERS + "/{userId}";
    public static final String USER_SIGN_IN = USER + "/_sign-in";
    public static final String USER_SIGN_OUT = USER + "/_sign-out";
    public static final String USER_SIGN_UP = USER + "/_sign-up";
    public static final String USER_REFRESH_TOKEN = USER + "/_refresh-token";

    /**
     * User Plant API Path
     */
    public static final String USER_PLANT = USERS_ID + "/plants";
    public static final String USER_PLANT_ID = USER_PLANT + "/{userPlantId}";

    /**
     * User Plant Checkup API Path
     */
    public static final String USER_PLANT_CHECKUP = USER_PLANT_ID + "/checkups";
    public static final String USER_PLANT_CHECKUP_ID = USER_PLANT_CHECKUP + "/{userPlantCheckupId}";

    /**
     * User Plant Checkup API Path
     */
    public static final String USER_PLANT_DISEASE = USER_PLANT_ID + "/diseases";
    public static final String USER_PLANT_DISEASE_ID = USER_PLANT_DISEASE + "/{userPlantDiseaseId}";

    /**
     * Plant API Path
     */
    public static final String PLANTS = API_PATH + "/plants";
    public static final String PLANTS_ID = PLANTS + "/{plantId}";

    /**
     * Plant Disease API Path
     */
    public static final String PLANT_DISEASE = PLANTS + "/diseases";
    public static final String PLANT_DISEASE_ID = PLANT_DISEASE + "/{plantDiseaseId}";

}
