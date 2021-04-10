DROP TABLE  IF EXISTS item; 
DROP TABLE  IF EXISTS category;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY ,
   `name` varchar(255) NOT NULL,
   `attribute_1` varchar(255) ,
   `attribute_2` varchar(255) , 
   `attribute_3` varchar(255) ,
   `last_update` DATE NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY ,
   `name` varchar(255) NOT NULL,
	`brand` varchar(255) NOT NULL,
   `initial_quantity` INT(11) NOT NULL DEFAULT '0',
   `quantity_left` INT(11),
     `category_id` INT(11) NOT NULL,
   `last_update` DATE NOT NULL,
   FOREIGN KEY (category_id) REFERENCES category(id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;