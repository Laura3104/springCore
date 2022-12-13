INSERT INTO users (name, email) VALUES
  ('Laura', 'laura.carmona@epam.com'),
  ('Camilo', 'camilo@epam.com');

INSERT INTO events (title, date) VALUES
  ('event1', '2020-10-01'),
  ('event2', '2020-10-01');

INSERT INTO tickets (category, place, user_id, event_id) VALUES
  ('science', 'cinema',  1L, 1L),
  ('math', 'cinema', 2L, 2L),
  ('history', 'cinema', 2L, 2L);