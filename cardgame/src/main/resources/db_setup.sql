INSERT INTO class (id, name) VALUES (1, 'Warrior'), (2, 'Mage'), (3, 'Paladin'), (4, 'Demon'), (5, 'Dwarf'), (6, 'Elfe');

-- Insert status effects
INSERT INTO status_effect (id, name, duration, healing_per_turn, armor_per_turn, damage_per_turn) VALUES
                                                                                                      (1, 'Poison', 3, 0, 0, 5),
                                                                                                      (2, 'Regeneration', 3, 5, 0, 0),
                                                                                                      (3, 'Shield', 3, 0, 5, 0);

-- Insert cards
INSERT INTO card (id, name, description, damage, self_damage, healing, armor, target_type, status_effect_id, class_id) VALUES
                                                                                                                           (1, 'Sword Strike', 'A basic attack with a sword', 10, 0, 0, 0, 'OPPONENT', NULL, 1), -- Warrior card
                                                                                                                           (2, 'Healing Potion', 'Heals the user', 0, 0, 20, 0, 'SELF', NULL, 1), -- Warrior card
                                                                                                                           (3, 'Fireball', 'A ball of fire that damages the opponent', 15, 0, 0, 0, 'OPPONENT', NULL, 2), -- Mage card
                                                                                                                           (4, 'Poison Dart', 'A dart that poisons the opponent', 5, 0, 0, 0, 'OPPONENT', 1, 2), -- Mage card
                                                                                                                           (5, 'Regeneration Spell', 'A spell that heals the user over time', 0, 0, 0, 0, 'SELF', 2, 2), -- Mage card
                                                                                                                           (6, 'Shield Spell', 'A spell that increases armor over time', 0, 0, 0, 0, 'SELF', 3, 2); -- Mage card

-- Insert players (example)
INSERT INTO player (id, name, life, armor, class_id) VALUES
                                                         (1, 'Player1', 100, 10, 1),
                                                         (2, 'Player2', 100, 10, 2);

-- Insert game (example)
 -- INSERT INTO game (id, player1_id, player2_id, is_player1_turn, is_player1_lost, is_player2_lost) VALUES
  --  (1, 1, 2, true, false, false);