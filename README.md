# blix_matriculas

Este proyecto es el trabajo final de curso Java 17 Backend - 2024




Para ejecutar este proyecto es necesario crear una bd de nombre blix_matriculas en postgres con clave de usuario blix.

El esquema de BD es el siguiente:


 IMAGEN BD

 Los comandos para poblar las dos primaeras tablas de la vd son

INSERT INTO public.student VALUES (1, 42, '41481234', 'Lazo', 'Alberto');
INSERT INTO public.student VALUES (2, 25, '12345678', 'Medina', 'Jaime');
INSERT INTO public.student VALUES (3, 5, '41481234', 'O''Keefe', 'Aracely');
INSERT INTO public.student VALUES (4, 43, '41481234', 'Bradtke', 'Golden');
INSERT INTO public.student VALUES (5, 66, '41481234', 'Hamill', 'Megane');
INSERT INTO public.student VALUES (6, 54, '41481234', 'Runte', 'Miguel');
INSERT INTO public.student VALUES (7, 18, '41481234', 'Carroll', 'Antone');
INSERT INTO public.student VALUES (8, 17, '41481234', 'Rolfson', 'Gabe');



INSERT INTO public.course VALUES (1, 'MAT', 'Math', true);
INSERT INTO public.course VALUES (2, 'Lang', 'Language', true);
INSERT INTO public.course VALUES (3, 'JAVA', 'Java 17', true);
INSERT INTO public.course VALUES (4, 'KOT', 'Kotlin', true);
INSERT INTO public.course VALUES (5, 'C++', 'C++', true);

Los JSON para poblar las tablas intermedias ( Maestro detalle ) son:

// STUDENT 1

{
    "id_registration": 1,
    "enroll_date": "2024-05-30T10:19:55",
    "student": { "id_student": 1},
    "details": [
        { "course": { "id_course": 1}, "room": "303", "registration": { "id_registration": 1 } },
        { "course": { "id_course": 2}, "room": "404", "registration": { "id_registration": 1 } },
        { "course": { "id_course": 3}, "room": "505", "registration": { "id_registration": 1 } },
        { "course": { "id_course": 4}, "room": "606", "registration": { "id_registration": 1 } },
        { "course": { "id_course": 5}, "room": "707", "registration": { "id_registration": 1 } }
    ],
    "status": true
}

// STUDENT 2

{
    "id_registration": 2,
    "enroll_date": "2024-05-30T10:19:55",
    "student": { "id_student": 2},
    "details": [
        { "course": { "id_course": 1}, "room": "303", "registration": { "id_registration": 2 } },
        { "course": { "id_course": 2}, "room": "404", "registration": { "id_registration": 2 } },
        { "course": { "id_course": 3}, "room": "505", "registration": { "id_registration": 2 } },
        { "course": { "id_course": 4}, "room": "606", "registration": { "id_registration": 2 } },
        { "course": { "id_course": 5}, "room": "707", "registration": { "id_registration": 2 } }
    ],
    "status": true
}

// STUDENT 3

{
    "id_registration": 3,
    "enroll_date": "2024-05-30T10:19:55",
    "student": { "id_student": 3},
    "details": [
        { "course": { "id_course": 1}, "room": "303", "registration": { "id_registration": 3 } },
        { "course": { "id_course": 2}, "room": "404", "registration": { "id_registration": 3 } },
        { "course": { "id_course": 3}, "room": "505", "registration": { "id_registration": 3 } }
    ],
    "status": true
}

El endpoint para la consulta 1 es 

http://localhost:8080/students/weee
