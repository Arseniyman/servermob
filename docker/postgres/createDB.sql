CREATE TABLE IF NOT EXISTS questionnaire
(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS question
(
    id BIGSERIAL PRIMARY KEY,
    text VARCHAR(60),
    questionnaire_id BIGINT REFERENCES questionnaire (id)
);

CREATE TABLE IF NOT EXISTS answer
(
    id BIGSERIAL PRIMARY KEY,
    text VARCHAR(100),
    question_id BIGINT REFERENCES question (id)
);

CREATE TABLE IF NOT EXISTS role
(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS usr
(
    id BIGSERIAL PRIMARY KEY,
    email VARCHAR(100),
    password CHAR(68),
    date_of_birth DATE,
    sex BOOLEAN,
    date_of_register DATE,
    last_online TIMESTAMP
);

CREATE TABLE IF NOT EXISTS user_roles
(
    user_id BIGINT REFERENCES usr (id),
    role_id BIGINT REFERENCES role (id),
    PRIMARY KEY (user_id, role_id)
);

CREATE TABLE IF NOT EXISTS selected_answer
(
    id BIGSERIAL PRIMARY KEY,
    usr_id BIGINT REFERENCES usr (id),
    answer_id INTEGER REFERENCES answer (id)
);

CREATE TABLE IF NOT EXISTS users_stat
(
    id BIGSERIAL PRIMARY KEY,
    day_online INTEGER,
    count_of_users INTEGER
);