/*Create a database called car_lot*/

use car_lot;

/*insert cars into car table*/

insert into car (id, make, model, model_year, color) values
	(1, 'Honda', 'Accord', '2012', 'Red'),
    (2, 'Chevy', 'Impala', '2017', 'Black'),
    (3, 'Ford', 'F-150', '2019', 'Silver'),
    (4, 'Subaru', 'Outback', '2020', 'White'),
    (5, 'Ford', 'Mustang', '2015', 'Silver'),
    (6, 'Honda', 'Ridgeline', '2018', 'Blue'),
    (7, 'Chevy', 'Silverado', '2017', 'Gray');
    
/*This is to update the existing records. Before attempting to update set the SQL_SAFE_UPDATES=0;*/
SET SQL_SAFE_UPDATES=0;
    
update car_lot.car set color = 'black' where make = 'Honda';
update car_lot.car set make = 'Cheverolet' where make = 'Chevy';
update car_lot.car set model_year = '2019' where model_year = '2020';

/*This is to delete some of the matching records. */
delete from car where color = 'blue';
delete from car where make = 'ford';
delete from car where model_year in ('2012', '2017');
 
 select * from car;
 
 use northwind;