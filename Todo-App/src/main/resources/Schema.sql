CREATE TABLE "Allan_project".task (
	"id_task" integer NOT null primary key,
	"title" varchar NOT null,
	"description" varchar not null,
	"status" varchar not null,
	due_date date  not null,
	"update_date" date not null,
	"id_user" integer,
	constraint task_user_fk foreign key (id_user)references "Allan_project".users(id_user)
	CREATE TABLE "Allan_project".users (
    	"id_user" integer NOT NULL integer NOT null primary key,,
    	first_name varchar NOT NULL,
    	suerename varchar NOT NULL,
    	phone integer NOT NULL,
    	email varchar NOT NULL
    );
    -- Column comments
    COMMENT ON COLUMN "Allan_project".users."Id_user(PK)" IS 'this is a integer it is the id of user ';

    INSERT INTO users(id_user, first_name, surname, phone, email)
    VALUES (1, 'Jose', 'lopez', '0918528099', 'sequeira_36@hotmail.com');

    INSERT INTO users(id_user, first_name, surname, phone, email)
    VALUES (2, 'pedro', 'perez', '+421918518099', 'sequeira_36@hotmail.com');

    INSERT INTO users(id_user, first_name, surname, phone, email)
    VALUES (3, 'vlado', 'perez', '+421918518089', 'vlado_36@hotmail.com');
    INSERT INTO users(id_user, first_name, surname, phone, email)
    VALUES (5, 'pepe', 'lopez', '+421918008099', 'pepe@hotmail.com');
    INSERT INTO users(id_user, first_name, surname, phone, email)
    VALUES (6, 'juan', 'pereira', '+421918618099', 'juan@hotmail.com');
    INSERT INTO users(id_user, first_name, surname, phone, email)
    VALUES (7, 'usnavi', 'rodriges', '+421918718099', 'usnavi@hotmail.com');
    INSERT INTO users(id_user, first_name, surname, phone, email)
    VALUES (8, 'zuzana', 'cickova', '+421928718099', 'zuzanacickova@hotmail.com');
    INSERT INTO users(id_user, first_name, surname, phone, email)
    VALUES (9, 'jan', 'kerezti', '+421999718099', 'jankeresti@hotmail.com');
    INSERT INTO users(id_user, first_name, surname, phone, email)
    VALUES (10, 'jose', 'cajina', '+421918768099', 'josecajina@hotmail.com');
    INSERT INTO users(id_user, first_name, surname, phone, email)
    VALUES (11, 'maria', 'cabrera', '+421911768099', 'mariacabrera@hotmail.com');
    INSERT INTO users(id_user, first_name, surname, phone, email)
    VALUES (12, 'peter', 'matlab', '+421922768099', 'petermatlab@hotmail.com');
    INSERT INTO users(id_user, first_name, surname, phone, email)
    VALUES (13, 'carlos', 'triana', '+421919968099', 'carlostriana@hotmail.com');
    INSERT INTO users(id_user, first_name, surname, phone, email)
    VALUES (14, 'maria', 'juana', '+421922768099', 'mariajuana@hotmail.com');
    INSERT INTO users(id_user, first_name, surname, phone, email)
    VALUES (15, 'concha', 'tumadre', '+421919958099', 'conchatumadre@hotmail.com');


    UPDATE users
    SET phone = '+421918518088'
    WHERE id_user = 1;