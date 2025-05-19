CREATE DATABASE stock_management;

CREATE TABLE IF NOT EXISTS categories(
    category INTEGER,
    name TEXT NOT NULL,
    PRIMARY KEY(category)
);

CREATE TABLE Products (
    sku VARCHAR(36) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price INTEGER NOT NULL,
    dimension_width INTEGER,
    dimension_height INTEGER,
    dimension_depth INTEGER,
    weight INTEGER,
    image_url TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Categories (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Product_Categories (
    product_sku VARCHAR(36),
    category_id INT,
    PRIMARY KEY (product_sku, category_id),
    FOREIGN KEY (product_sku) REFERENCES Products(sku) ON DELETE CASCADE,
    FOREIGN KEY (category_id) REFERENCES Categories(id) ON DELETE CASCADE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Stock (
    product_sku VARCHAR(36) PRIMARY KEY,
    quantity INTEGER NOT NULL DEFAULT 0,
    last_updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (product_sku) REFERENCES Products(sku)
);