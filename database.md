# Database Design
Tables are unlinked to easily allow users to make posts anonymously.

## lfg_posts
| Field       | Type         | Null | Key | Default | Extra          |
|---|---|---|---|---|---|
|looking_for  | varchar(10)  | YES  |     | NULL    | |
|ID           | int(11)      | NO   | PRI | NULL    | auto_increment |
|username     | varchar(20)  | YES  |     | NULL    | |
|region       | varchar(50)  | YES  |     | NULL    | |
|player_class | varchar(50)  | YES  |     | NULL    | |
|level        | int(5)       | YES  |     | NULL    | |
|gear_rating  | int(50)      | YES  |     | NULL    | |
|activity     | varchar(50)  | YES  |     | NULL    | |
|description  | varchar(250) | YES  |     | NULL    | |
|have_mic     | tinyint(1)   | YES  |     | NULL    | |
|time_posted  | date         | YES  |     | NULL    | |
|platform     | varchar(50)  | YES  |     | NULL    | |
|experience   | varchar(10)  | YES  |     | NULL    | |
|looking_for  | varchar(10)  | YES  |     | NULL    | |

## users (WIP)
| Field        | Type        | Null | Key | Default | Extra |
|---|---|---|---|---|---|
| user_name    | varchar(15) | NO   | PRI | NULL    |       |
| user_pass    | varchar(15) | NO   |     | NULL    |       |
| wow_user     | varchar(50) | YES  |     | NULL    |       |
| wow_realm    | varchar(20) | YES  |     | NULL    |       |
| char_level   | int(5)      | YES  |     | NULL    |       |
| item_level   | int(5)      | YES  |     | NULL    |       |
| player_class | varchar(25)      | YES  |     | NULL    |       |


