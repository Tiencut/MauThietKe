IF DB_ID('OrderCompositeDB') IS NULL
    CREATE DATABASE OrderCompositeDB;
GO

USE OrderCompositeDB;
GO

IF OBJECT_ID('dbo.order_components', 'U') IS NULL
BEGIN
    CREATE TABLE dbo.order_components (
        id INT PRIMARY KEY,
        name NVARCHAR(255) NOT NULL,
        component_type VARCHAR(20) NOT NULL,
        unit_price DECIMAL(18,2) NULL,
        quantity INT NULL,
        parent_id INT NULL,
        CONSTRAINT fk_order_components_parent
            FOREIGN KEY (parent_id) REFERENCES dbo.order_components(id)
    );
END
GO
