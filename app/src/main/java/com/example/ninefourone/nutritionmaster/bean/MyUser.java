package com.example.ninefourone.nutritionmaster.bean;

import java.util.List;

public class MyUser {

    /**
     * id : 2
     * eaten_elements : {"id":12127,"calorie":1046,"carbohydrate":33.56923076923077,"fat":17.138461538461538,"protein":13.492307692307692,"cellulose":5.723076923076923,"vitaminA":16.307692307692307,"vitaminB1":0,"vitaminB2":0.16,"vitaminB6":0,"vitaminC":9.692307692307692,"vitaminE":7.483076923076923,"carotene":84.61538461538461,"cholesterol":29.692307692307693,"Mg":116.61538461538461,"Ca":230.76923076923077,"Fe":7.523076923076923,"Zn":1.209230769230769,"Cu":0.4138461538461539,"Mn":1.5138461538461538,"K":285.6923076923077,"P":92,"Na":15580.876923076923,"Se":7.636923076923078,"niacin":1.169230769230769,"thiamine":0.06307692307692307}
     * physical_name : 瘀血质
     * password : updata
     * last_login : null
     * is_superuser : false
     * username : updatatest
     * first_name :
     * last_name :
     * email :
     * is_staff : false
     * is_active : false
     * date_joined : 2018-09-16T20:21:40.466423+08:00
     * sex : 1
     * age : 0
     * height : 0
     * weight : 0
     * bmi : -1
     * occupation_name : null
     * groups : []
     * user_permissions : []
     * illness : []
     */

    private Integer id;
    private EatenElementsBean eaten_elements;
    private String physical_name;
    private String password;
    private Object last_login;
    private Boolean is_superuser;
    private String username;
    private String first_name;
    private String last_name;
    private String email;
    private Boolean is_staff;
    private Boolean is_active;
    private String date_joined;
    private Integer sex;
    private Integer age;
    private Integer height;
    private Integer weight;
    private Integer bmi = new Integer(-1);
    private String occupation_name;
    private List<?> groups;
    private List<?> user_permissions;
    private List<?> illness;

    public MyUser() {
        height = new Integer(0);
        occupation_name = "";
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "id=" + id +
                ", eaten_elements=" + eaten_elements +
                ", physical_name='" + physical_name + '\'' +
                ", password='" + password + '\'' +
                ", last_login=" + last_login +
                ", is_superuser=" + is_superuser +
                ", username='" + username + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", is_staff=" + is_staff +
                ", is_active=" + is_active +
                ", date_joined='" + date_joined + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", bmi=" + bmi +
                ", occupation_name=" + occupation_name +
                ", groups=" + groups +
                ", user_permissions=" + user_permissions +
                ", illness=" + illness +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EatenElementsBean getEaten_elements() {
        return eaten_elements;
    }

    public void setEaten_elements(EatenElementsBean eaten_elements) {
        this.eaten_elements = eaten_elements;
    }

    public String getPhysical_name() {
        return physical_name;
    }

    public void setPhysical_name(String physical_name) {
        this.physical_name = physical_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Object getLast_login() {
        return last_login;
    }

    public void setLast_login(Object last_login) {
        this.last_login = last_login;
    }

    public Boolean getIs_superuser() {
        return is_superuser;
    }

    public void setIs_superuser(Boolean is_superuser) {
        this.is_superuser = is_superuser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIs_staff() {
        return is_staff;
    }

    public void setIs_staff(Boolean is_staff) {
        this.is_staff = is_staff;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public String getDate_joined() {
        return date_joined;
    }

    public void setDate_joined(String date_joined) {
        this.date_joined = date_joined;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getBmi() {
        return bmi;
    }

    public void setBmi(Integer bmi) {
        this.bmi = bmi;
    }

    public String getOccupation_name() {
        return occupation_name;
    }

    public void setOccupation_name(String occupation_name) {
        this.occupation_name = occupation_name;
    }

    public List<?> getGroups() {
        return groups;
    }

    public void setGroups(List<?> groups) {
        this.groups = groups;
    }

    public List<?> getUser_permissions() {
        return user_permissions;
    }

    public void setUser_permissions(List<?> user_permissions) {
        this.user_permissions = user_permissions;
    }

    public List<?> getIllness() {
        return illness;
    }

    public void setIllness(List<?> illness) {
        this.illness = illness;
    }

    public static class EatenElementsBean {
        /**
         * id : 12127
         * calorie : 1046
         * carbohydrate : 33.56923076923077
         * fat : 17.138461538461538
         * protein : 13.492307692307692
         * cellulose : 5.723076923076923
         * vitaminA : 16.307692307692307
         * vitaminB1 : 0
         * vitaminB2 : 0.16
         * vitaminB6 : 0
         * vitaminC : 9.692307692307692
         * vitaminE : 7.483076923076923
         * carotene : 84.61538461538461
         * cholesterol : 29.692307692307693
         * Mg : 116.61538461538461
         * Ca : 230.76923076923077
         * Fe : 7.523076923076923
         * Zn : 1.209230769230769
         * Cu : 0.4138461538461539
         * Mn : 1.5138461538461538
         * K : 285.6923076923077
         * P : 92
         * Na : 15580.876923076923
         * Se : 7.636923076923078
         * niacin : 1.169230769230769
         * thiamine : 0.06307692307692307
         */

        private double id;
        private double calorie;
        private double carbohydrate;
        private double fat;
        private double protein;
        private double cellulose;
        private double vitaminA;
        private double vitaminB1;
        private double vitaminB2;
        private double vitaminB6;
        private double vitaminC;
        private double vitaminE;
        private double carotene;
        private double cholesterol;
        private double Mg;
        private double Ca;
        private double Fe;
        private double Zn;
        private double Cu;
        private double Mn;
        private double K;
        private double P;
        private double Na;
        private double Se;
        private double niacin;
        private double thiamine;

        @Override
        public String toString() {
            return "EatenElementsBean{" +
                    "id=" + id +
                    ", calorie=" + calorie +
                    ", carbohydrate=" + carbohydrate +
                    ", fat=" + fat +
                    ", protein=" + protein +
                    ", cellulose=" + cellulose +
                    ", vitaminA=" + vitaminA +
                    ", vitaminB1=" + vitaminB1 +
                    ", vitaminB2=" + vitaminB2 +
                    ", vitaminB6=" + vitaminB6 +
                    ", vitaminC=" + vitaminC +
                    ", vitaminE=" + vitaminE +
                    ", carotene=" + carotene +
                    ", cholesterol=" + cholesterol +
                    ", Mg=" + Mg +
                    ", Ca=" + Ca +
                    ", Fe=" + Fe +
                    ", Zn=" + Zn +
                    ", Cu=" + Cu +
                    ", Mn=" + Mn +
                    ", K=" + K +
                    ", P=" + P +
                    ", Na=" + Na +
                    ", Se=" + Se +
                    ", niacin=" + niacin +
                    ", thiamine=" + thiamine +
                    '}';
        }

        public double getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getCalorie() {
            return calorie;
        }

        public void setCalorie(int calorie) {
            this.calorie = calorie;
        }

        public double getCarbohydrate() {
            return carbohydrate;
        }

        public void setCarbohydrate(double carbohydrate) {
            this.carbohydrate = carbohydrate;
        }

        public double getFat() {
            return fat;
        }

        public void setFat(double fat) {
            this.fat = fat;
        }

        public double getProtein() {
            return protein;
        }

        public void setProtein(double protein) {
            this.protein = protein;
        }

        public double getCellulose() {
            return cellulose;
        }

        public void setCellulose(double cellulose) {
            this.cellulose = cellulose;
        }

        public double getVitaminA() {
            return vitaminA;
        }

        public void setVitaminA(double vitaminA) {
            this.vitaminA = vitaminA;
        }

        public double getVitaminB1() {
            return vitaminB1;
        }

        public void setVitaminB1(int vitaminB1) {
            this.vitaminB1 = vitaminB1;
        }

        public double getVitaminB2() {
            return vitaminB2;
        }

        public void setVitaminB2(double vitaminB2) {
            this.vitaminB2 = vitaminB2;
        }

        public double getVitaminB6() {
            return vitaminB6;
        }

        public void setVitaminB6(int vitaminB6) {
            this.vitaminB6 = vitaminB6;
        }

        public double getVitaminC() {
            return vitaminC;
        }

        public void setVitaminC(double vitaminC) {
            this.vitaminC = vitaminC;
        }

        public double getVitaminE() {
            return vitaminE;
        }

        public void setVitaminE(double vitaminE) {
            this.vitaminE = vitaminE;
        }

        public double getCarotene() {
            return carotene;
        }

        public void setCarotene(double carotene) {
            this.carotene = carotene;
        }

        public double getCholesterol() {
            return cholesterol;
        }

        public void setCholesterol(double cholesterol) {
            this.cholesterol = cholesterol;
        }

        public double getMg() {
            return Mg;
        }

        public void setMg(double Mg) {
            this.Mg = Mg;
        }

        public double getCa() {
            return Ca;
        }

        public void setCa(double Ca) {
            this.Ca = Ca;
        }

        public double getFe() {
            return Fe;
        }

        public void setFe(double Fe) {
            this.Fe = Fe;
        }

        public double getZn() {
            return Zn;
        }

        public void setZn(double Zn) {
            this.Zn = Zn;
        }

        public double getCu() {
            return Cu;
        }

        public void setCu(double Cu) {
            this.Cu = Cu;
        }

        public double getMn() {
            return Mn;
        }

        public void setMn(double Mn) {
            this.Mn = Mn;
        }

        public double getK() {
            return K;
        }

        public void setK(double K) {
            this.K = K;
        }

        public double getP() {
            return P;
        }

        public void setP(int P) {
            this.P = P;
        }

        public double getNa() {
            return Na;
        }

        public void setNa(double Na) {
            this.Na = Na;
        }

        public double getSe() {
            return Se;
        }

        public void setSe(double Se) {
            this.Se = Se;
        }

        public double getNiacin() {
            return niacin;
        }

        public void setNiacin(double niacin) {
            this.niacin = niacin;
        }

        public double getThiamine() {
            return thiamine;
        }

        public void setThiamine(double thiamine) {
            this.thiamine = thiamine;
        }
    }
}
