create
    definer = m290@`%` procedure delete_user_by_id(IN userId bigint)
BEGIN
    DELETE FROM user_role0329 ur where ur.user_id=userId;
    DELETE FROM user0319 u WHERE u.id=userId;
end;

