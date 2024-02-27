# --\       Ingredient       /--

INSERT INTO ingredient (name, unity_type)
VALUES ('Flour', 'GRAM'),
       ('Sugar', 'GRAM'),
       ('Salt', 'GRAM'),
       ('Baking powder', 'GRAM'),
       ('Baking soda', 'GRAM'),
       ('Butter', 'GRAM'),
       ('Eggs', 'PIECE'),
       ('Whole milk', 'LITER'),
       ('Skim milk', 'LITER'),
       ('Almond milk', 'LITER'),
       ('Soy milk', 'LITER'),
       ('Coconut milk', 'LITER'),
       ('Vanilla extract', 'MILLILITER'),
       ('Chocolate chips', 'GRAM'),
       ('Chocolate bars', 'GRAM'),
       ('Cocoa powder', 'GRAM'),
       ('Vegetable oil', 'LITER'),
       ('Olive oil', 'LITER'),
       ('Canola oil', 'LITER'),
       ('Coconut oil', 'LITER'),
       ('Heavy cream', 'LITER'),
       ('Whipping cream', 'LITER'),
       ('Sour cream', 'GRAM'),
       ('Honey', 'MILLILITER'),
       ('Almonds', 'GRAM'),
       ('Walnuts', 'GRAM'),
       ('Pecans', 'GRAM'),
       ('Peanuts', 'GRAM'),
       ('Apples', 'PIECE'),
       ('Bananas', 'PIECE'),
       ('Strawberries', 'GRAM'),
       ('Blueberries', 'GRAM'),
       ('Raspberries', 'GRAM'),
       ('Oranges', 'PIECE'),
       ('Lemons', 'PIECE'),
       ('Carrots', 'GRAM'),
       ('Spinach', 'GRAM'),
       ('Onions', 'GRAM'),
       ('Tomatoes', 'GRAM'),
       ('Bell peppers', 'GRAM'),
       ('Cinnamon', 'GRAM'),
       ('Nutmeg', 'GRAM'),
       ('Ginger', 'GRAM'),
       ('Cloves', 'GRAM'),
       ('Paprika', 'GRAM'),
       ('Basil', 'GRAM'),
       ('Parsley', 'GRAM'),
       ('Cilantro', 'GRAM'),
       ('Rosemary', 'GRAM'),
       ('Thyme', 'GRAM'),
       ('Ketchup', 'MILLILITER'),
       ('Mustard', 'MILLILITER'),
       ('Mayonnaise', 'MILLILITER'),
       ('Soy sauce', 'MILLILITER'),
       ('Worcestershire sauce', 'MILLILITER');

# --\       Category       /--

INSERT INTO category (name)
VALUES
    ('Italian'),
    ('Mexican'),
    ('Chinese'),
    ('Indian'),
    ('Japanese'),
    ('French'),
    ('Thai'),
    ('Spanish'),
    ('Greek'),
    ('Mediterranean'),
    ('American'),
    ('Middle Eastern'),
    ('Korean'),
    ('Vietnamese'),
    ('Brazilian'),
    ('Caribbean'),
    ('African'),
    ('British'),
    ('German'),
    ('Russian'),
    ('Scandinavian'),
    ('Cajun/Creole'),
    ('Filipino'),
    ('Indonesian'),
    ('Malaysian'),
    ('Turkish'),
    ('Lebanese'),
    ('Moroccan'),
    ('Peruvian'),
    ('Argentine');

# --\       Tag       /--

INSERT INTO tag (name)
VALUES
    ('Vegetarian'),
    ('Vegan'),
    ('Gluten-Free'),
    ('Dairy-Free'),
    ('Low-Carb'),
    ('High-Protein'),
    ('Paleo'),
    ('Keto'),
    ('Quick & Easy'),
    ('Budget-Friendly'),
    ('One-Pot'),
    ('Slow Cooker'),
    ('Instant Pot'),
    ('Meal Prep'),
    ('Kid-Friendly'),
    ('Breakfast'),
    ('Brunch'),
    ('Lunch'),
    ('Dinner'),
    ('Appetizer'),
    ('Snack'),
    ('Dessert'),
    ('Healthy'),
    ('Comfort Food'),
    ('Spicy'),
    ('Mild'),
    ('Savory'),
    ('Sweet'),
    ('Tangy'),
    ('Fresh'),
    ('Seasonal'),
    ('Holiday'),
    ('Summer'),
    ('Winter'),
    ('Spring'),
    ('Fall'),
    ('Grilled'),
    ('Baked'),
    ('Fried'),
    ('Steamed'),
    ('Roasted'),
    ('Sauteed'),
    ('Stir-Fried'),
    ('Gravy'),
    ('Sauce'),
    ('Salad'),
    ('Soup'),
    ('Stew'),
    ('Curry'),
    ('Casserole');

# --\       Recipe       /--

insert into recipe (title,description)
values
    ('Spaghetti Carbonara','Spaghetti Carbonara description'),
    ('Chicken Alfredo','Chicken Alfredo description'),
    ('Chicken Parmesan','Chicken Parmesan description'),
    ('Chicken Marsala','Chicken Marsala description'),
    ('Chicken Piccata','Chicken Piccata description'),
    ('Chicken Cacciatore','Chicken Cacciatore description'),
    ('Chicken Fettuccine Alfredo','Chicken Fettuccine Alfredo description'),
    ('Chicken Tetrazzini','Chicken Tetrazzini description');


# --\       Recipe Steps       /--

insert into recipe_steps (recipe_id, step)
values (1, 'Preheat the oven to 350°F (175°C).'),
       (1, 'In a large mixing bowl, combine the flour, sugar, baking powder, and salt.'),
       (1, 'In a separate bowl, whisk together the eggs, milk, and melted butter.'),
       (1, 'Pour the wet ingredients into the dry ingredients and mix until just combined.'),
       (1, 'Gently fold in the blueberries.'),
       (1, 'Pour the batter into a greased baking dish.'),
       (1, 'Bake for 40-45 minutes or until golden brown and a toothpick inserted into the center comes out clean.'),
       (1, 'Allow the cake to cool slightly before serving.');

insert into recipe_steps (recipe_id, step)
values (2, 'Cook the pasta according to package instructions until al dente. Drain and set aside.'),
       (2, 'In a large skillet, heat olive oil over medium heat.'),
       (2, 'Add minced garlic and cook for 1-2 minutes until fragrant.'),
       (2, 'Stir in diced tomatoes, tomato paste, and Italian seasoning.'),
       (2, 'Simmer the sauce for 10-15 minutes until slightly thickened.'),
       (2, 'Add the cooked pasta to the skillet and toss to coat evenly with the sauce.'),
       (2, 'Sprinkle with grated Parmesan cheese and chopped fresh basil before serving.'),
       (2, 'Enjoy your delicious homemade pasta!');

# --\       Comment       /--

insert into comment (recipe_id, user_id, content)
values (1, '1', 'This recipe is amazing!'),
       (1, '1', 'I love it!'),
       (2, '1', 'This recipe is amazing!'),
       (2, '2', 'I love it!');

# --\       Favorite       /--

insert into favorite (recipe_id, user_id)
values
    (1, 1),
    (2, 2),
    (3, 2),
    (4, 1),
    (5, 1),
    (6, 2),
    (7, 1),
    (8, 2);


# insert into recipe_tags (recipe_id, tag_id)
# values (1, 2),
#        (1, 3),
#        (2, 1),
#        (2, 2),
#        (2, 3);

