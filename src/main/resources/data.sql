INSERT INTO users (name, email) VALUES
  ('Laura', 'laura.carmona@epam.com'),
  ('Camilo', 'camilo@epam.com');

INSERT INTO events (title, date) VALUES
  ('event1', '2020-10-01'),
  ('event1', '2020-10-01'),
  ('event2', '2020-10-01');

INSERT INTO tickets (category, place, user_id, event_id) VALUES
  ('CONFERENCES', 1,  1L, 1L),
  ('SEMINARS', 2, 2L, 2L),
  ('SEMINARS', 1, 2L, 2L);