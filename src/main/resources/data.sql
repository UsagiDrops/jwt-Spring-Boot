INSERT INTO `role` (`role_name`) VALUES ('USER');
INSERT INTO `role` (`role_name`) VALUES ('EDITOR');
INSERT INTO `role` (`role_name`) VALUES ('ADMIN');

INSERT INTO `users` (`username`, `password`) VALUES ('user1', '$2a$10$DsI0IQwDUaVn3PpBOtj3fulHX7b9rFJ2/HNNvH6PX5D3XfOieEwce');
INSERT INTO `users` (`username`, `password`) VALUES ('user2', '$2a$10$DsI0IQwDUaVn3PpBOtj3fulHX7b9rFJ2/HNNvH6PX5D3XfOieEwce');
INSERT INTO `users` (`username`, `password`) VALUES ('user3', '$2a$10$DsI0IQwDUaVn3PpBOtj3fulHX7b9rFJ2/HNNvH6PX5D3XfOieEwce');

INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (1, 1);
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (2, 2);
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (3, 3);