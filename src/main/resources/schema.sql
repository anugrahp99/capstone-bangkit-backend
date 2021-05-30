CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS "users"  (
  "id" varchar PRIMARY KEY DEFAULT uuid_generate_v4(),
  "fullname" varchar,
  "email" varchar UNIQUE NOT NULL,
  "image" varchar,
  "address" varchar,
  "city" varchar,
  "password" varchar,
  "sex" int,
  "role" varchar,
    "created_at" timestamp DEFAULT (now()),
    "updated_at" timestamp DEFAULT (now()),
    "deleted" int DEFAULT 0
);

CREATE TABLE IF NOT EXISTS "plants" (
  "id" varchar PRIMARY KEY DEFAULT uuid_generate_v4(),
  "plant_name" varchar UNIQUE NOT NULL,
  "plant_class" varchar,
  "plant_species" varchar,
  "plant_humidity" decimal,
  "plant_lighting" decimal,
  "plant_fertilizer" decimal,
  "plant_price" decimal,
  "plant_sales_price" decimal,
  "plant_month_harvest" varchar,
  "plant_preparation" text,
    "created_at" timestamp DEFAULT (now()),
    "updated_at" timestamp DEFAULT (now()),
    "deleted" int DEFAULT 0
);

CREATE TABLE IF NOT EXISTS "plant_diseases" (
  "id" varchar PRIMARY KEY DEFAULT uuid_generate_v4(),
  "disease_name" varchar UNIQUE NOT NULL,
  "disease_detail" text,
  "disease_treatment" text,
  "disease_treatment_videos" text,
    "created_at" timestamp DEFAULT (now()),
    "updated_at" timestamp DEFAULT (now()),
    "deleted" int DEFAULT 0
);

CREATE TABLE IF NOT EXISTS "user_plants" (
  "id" varchar PRIMARY KEY DEFAULT uuid_generate_v4(),
  "plant_id" varchar,
  "user_id" varchar,
  "user_plant_name" varchar,
  "plant_health" decimal,
  "plant_image" varchar,
  "plant_detail" text,
  "plant_phase" varchar,
  "plant_suggestion" text,
  "created_at" timestamp DEFAULT (now()),
  "updated_at" timestamp DEFAULT (now()),
  "deleted" int DEFAULT 0
);

CREATE TABLE IF NOT EXISTS "user_plant_checkups" (
  "id" varchar PRIMARY KEY DEFAULT uuid_generate_v4(),
  "user_plant_id" varchar,
  "user_plant_humidity" decimal,
  "user_plant_temperature" decimal,
  "user_plant_nitrogen" decimal DEFAULT 0,
  "user_plant_potassium" decimal DEFAULT 0,
  "user_plant_phosphorus" decimal DEFAULT 0,
    "created_at" timestamp DEFAULT (now()),
    "updated_at" timestamp DEFAULT (now()),
    "deleted" int DEFAULT 0
);

CREATE TABLE IF NOT EXISTS "user_plant_diseases" (
  "id" varchar PRIMARY KEY DEFAULT uuid_generate_v4(),
  "user_plant_id" varchar,
  "plant_disease_id" varchar,
    "created_at" timestamp DEFAULT (now()),
    "updated_at" timestamp DEFAULT (now()),
    "deleted" int DEFAULT 0
);

ALTER TABLE "user_plants" ADD FOREIGN KEY ("plant_id") REFERENCES "plants" ("id");

ALTER TABLE "user_plants" ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id");

ALTER TABLE "user_plant_checkups" ADD FOREIGN KEY ("user_plant_id") REFERENCES "user_plants" ("id");

ALTER TABLE "user_plant_diseases" ADD FOREIGN KEY ("user_plant_id") REFERENCES "user_plants" ("id");

ALTER TABLE "user_plant_diseases" ADD FOREIGN KEY ("plant_disease_id") REFERENCES "plant_diseases" ("id");

-- INSERT INTO plants(
--     plant_name, plant_class, plant_species, plant_humidity,
--     plant_lighting, plant_fertilizer, plant_price, plant_sales_price,
--     plant_month_harvest, plant_preparation)
-- VALUES ('Jagung','Monocotyledone','Zea Mays',63.69071, 30, 40, 10000, 20000, 'Summer', 'Padi Preparation'),
--        ('Anggur','Magnoliopsida','Vitis Vinifera',81.54156612, 30, 40, 10000, 20000, 'Summer', 'Padi Preparation'),
--        ('Jeruk','Magnoliopsida','Citrus sp',92.51077745, 30, 40, 10000, 20000, 'Summer', 'Padi Preparation'),
--        ('Apel','Magnoliopsida','M. domestica',90.69489172, 30, 40, 10000, 20000, 'Summer', 'Padi Preparation'),
--        ('Kacang Kedelai','Dicotyledonae','Glycine max', 20, 30, 40, 10000, 20000, 'Summer', 'Padi Preparation');
--
-- INSERT INTO plant_diseases (disease_name, disease_detail,disease_treatment,disease_treatment_videos)
-- VALUES('Apple Scab','Apple scab is the most common disease of apple and crabapple trees in Minnesota.','For the treatment, we suggest you to do pesticide spraying','https://youtu.be/TenRNA_usxA'),
--       ('Black Rot','Black rot is occasionally a problem on Minnesota apple trees. This fungal disease causes leaf spot, fruit rot and cankers on branches','For the treatment, we suggest you to do pesticide spraying','https://youtu.be/TenRNA_usxA'),
--       ('Cedar Apple Rust','Cedar-apple rust and related rust fungi need plants from two plant families to complete their life cycle; Cupressaceae family (eastern red cedar and other junipers) and Rosaceae (apple, hawthorn, serviceberry)','For the treatment, we suggest you to do pesticide spraying','https://youtu.be/TenRNA_usxA'),
--       ('Cercospora Leaf Spot or Grey Leaf Spot', 'Severely affected beet plants (Photo E. Crawford) & heavy disease pressure on leaf','For the treatment, we suggest you to do pesticide spraying','https://youtu.be/TenRNA_usxA'),
--       ('Common Rust','Common rust is caused by the fungus Puccinia sorghi. Late occurring infections have limited impact on yield.','For the treatment, we suggest you to do pesticide spraying','https://youtu.be/TenRNA_usxA'),
--       ('Esca (Black Measles)',' Esca (black measles) is considered a disease of older vines.','For the treatment, we suggest you to do pesticide spraying','https://youtu.be/TenRNA_usxA'),
--       ('Leaf Blight (Isariopsis Leaf Spot)','Leaf blight disease is caused by the fungus Helminthosporium turcicum Pass. The disease develops on sorghum leaves particularly under humid conditions by producing reddish-purple or tan spots that coalesce to form large lesions.','For the treatment, we suggest you to do pesticide spraying','https://youtu.be/TenRNA_usxA'),
--       ('Haunglongbing (Citrus Greening)','Huanglongbing (yellow dragon disease), previously known as citrus greening, is one of the worst diseases of citrus trees in the world. It is caused by the bacterial disease Candidatus Liberibacter asiaticus, which spreads through the tree canopy, causing decline and then death of the tree.','For the treatment, we suggest you to do pesticide spraying','https://youtu.be/TenRNA_usxA');
