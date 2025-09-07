 =============================================
-- Author:		Name
-- Create date: 
-- Description:	
-- =============================================
CREATE PROCEDURE [dbo].[uspgetEmployeesByLastName] 
	-- Add the parameters for the stored procedure here
	@lastNameStartsWith varchar(20) = 'S'
	
--AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

   
	SELECT * from [dbo].Employee
	WHERE (name like @lastNameStartsWith + '%')
END//
