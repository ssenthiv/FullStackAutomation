-- =============================================
Author:		Name
-- Create date: 
-- Description:	
-- =============================================
--CREATE PROCEDURE [dbo].[uspgetEmployeesByLastName] 
	-- Add the parameters for the stored procedure here
	@lastNameStartsWith varchar(20) = 'S'
	
AS
BEGIN
	-- SET NOCOUNT ON added to prevent 
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT * from [dbo].Employee
	WHERE (name like @lastNameStartsWith + '%')
END --Added newly
