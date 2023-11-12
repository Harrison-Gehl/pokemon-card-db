CREATE TABLE card_id (
  -- info used to make Primary Key
  card_num varchar(45) NOT NULL,
  series varchar(45) NOT NULL,
  lang varchar(45) NOT NULL,
  PRIMARY KEY (`card_num`,`series`,`lang`),
  
  -- attributes about the card
  pokemon_name VARCHAR(45) NOT NULL,
  card_type VARCHAR(45) NOT NULL,
  
  -- holo vs normal
  normal_art TINYINT UNSIGNED NULL DEFAULT 0,
  holo TINYINT UNSIGNED NULL DEFAULT 0,
  reverse_holo TINYINT UNSIGNED NULL DEFAULT 0,
  full_holo TINYINT UNSIGNED NULL DEFAULT 0
);

