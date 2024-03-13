{ pkgs }: {
  deps = [
    pkgs.  # 첫 번째 반복일 때에만 max_name 초기화  if (i == 0):    max_name = name  # 2개씩의 보상 추가  have += 2 * int(have / need)  new += int(have / need)  N_list[name] = new  # max_name 갱신  if (new > N_list[max_name]):    max_name = namenum_list = list(N_list.values())print(sum(num_list))print(max_name)
  ];
}