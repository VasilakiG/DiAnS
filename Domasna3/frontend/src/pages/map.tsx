import Layout from "@/components/layout/layout";
import dynamic from "next/dynamic";
import React, { ReactElement } from "react";
const DynamicMap = dynamic(() => import('@/components/dynamic_map'), { ssr: false });

export default function MapPage(){
	return (
		<>
			<DynamicMap />
		</>
	);
};

MapPage.getLayout = function getLayout(page: ReactElement) {
	return <Layout>{page}</Layout>;
};