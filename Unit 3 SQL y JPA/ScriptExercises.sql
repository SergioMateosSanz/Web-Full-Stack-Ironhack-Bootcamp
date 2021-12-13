-- Promedio de notas por estudiante
SELECT student_name, AVG(score) FROM grade GROUP BY student_name;
-- Total de cursos tomado por cada estudiante
SELECT student_name, COUNT(section_id) FROM grade GROUP BY student_name;
-- La nota más baja por sección
SELECT section_id, MIN(score)  FROM grade GROUP BY section_id;
-- La nota más alta por sección
SELECT section_id, MAX(score)  FROM grade GROUP BY section_id;
-- Nombre y nota de todos los estudiantes de la sección CS103 ordenados por nota de mayor a menor
SELECT student_name, score  FROM grade WHERE section_id LIKE 'CS103%' ORDER BY score DESC;
-- Lista alfabética de los distintos estudiantes cuyos nombres caigan alfabéticamente desde la L hasta la R
SELECT DISTINCT student_name FROM grade WHERE student_name between 'L' AND 'R' ORDER BY student_name ;

/*Nombre, nota y nombre del instructor de todos los estudiantes
Nombre, nota y nombre del curso de todos los estudiantes que hayan estudiado en un curso llamado “Databases”
*/
SELECT student_name, score, professor FROM grade g INNER JOIN section s ON g.section_id = s.id; 

SELECT student_name, score, course_name 
FROM grade g 
INNER JOIN section s ON g.section_id = s.id 
INNER JOIN course c ON c.course_code = s.course_code 
WHERE c.course_name = 'Databases'; 