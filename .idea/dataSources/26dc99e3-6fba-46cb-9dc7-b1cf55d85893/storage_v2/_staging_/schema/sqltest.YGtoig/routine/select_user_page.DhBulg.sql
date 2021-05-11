create
    definer = m290@`%` procedure select_user_page(IN userName varchar(32), IN _offset bigint,
    IN _limit bigint,
                                                  OUT total bigint)
BEGIN
        /*查询数据总数*/
        select count(*) INTO total
        from user0319 u
            where u.userName like concat('%',userName,'%');

        /*分页数据*/
        select *
            from user0319 u
                where u.userName like concat('%',userName,'%')
            limit _offset,_limit;
    end;

